package company.amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
    https://leetcode.com/discuss/interview-question/1299963/amazon-sde2-phone-screen-product-recommendation

    Problem: Product Recommendation based on most bought products by friends.

    Given two APIs - one to get a list of friends and another one to get a list of someone's recent purchases

    Design an API which returns a list of x number of products purchased by most friends (popular purchases),
    order should be based on "ordered by most to least people in one's friends list".
    Make sure to include "one purchase per product per person" to not skew the results.
    What would be the time complexity of the solution?

    refer:
        - https://leetcode.com/problems/get-watched-videos-by-your-friends/description/
        - https://leetcode.com/discuss/interview-question/457517/Get-Videos-Liked-by-Friends

    - Get friends by an user, N friends
    - Get a list of recent perchase per each friends, average M products per each user
    - Make productToCount with HashMap
*/

record Product(String name) {}

record User(String name) {}

record ProductRecommendation(Product product, int score) {}

interface ProductService {
  List<Product> getProductsRecentPurchased(User user);
}

interface FriendService {
  List<User> getFriends(User user);
}

interface RecommendService {
  List<ProductRecommendation> getProductsMostPurchasedByFriends(User user, int topK);
}

class ProductRecommender implements RecommendService {

  private final ProductService productService;
  private final FriendService friendService;

  ProductRecommender(ProductService productService, FriendService friendService) {
    this.productService = productService;
    this.friendService = friendService;
  }

  public List<ProductRecommendation> getProductsMostPurchasedByFriends(User user, int topK) {
    var productToCount = new HashMap<Product, Integer>();

    var friends = friendService.getFriends(user);
    // O(N*M)
    for (var friend : friends) {
      HashSet<Product> recentPurchasedProducts =
          new HashSet<>(productService.getProductsRecentPurchased(friend));

      for (var product : recentPurchasedProducts) {
        int preCount = productToCount.getOrDefault(product, 0);
        productToCount.put(product, preCount + 1);
      }
    }

    return productToCount.entrySet().stream()
        .map(e -> new ProductRecommendation(e.getKey(), e.getValue()))
        .sorted(Comparator.comparing(ProductRecommendation::score).reversed())
        .limit(topK)
        .toList();
  }
}

class Demo {

  public static void main(String[] args) {
    /*
    Two most pupular products

    A's friends - B, C, D
    B's purchases - Apple, Apple, Apple, Kiwi, Cherry
    C's purchases - Kiwi, Cherry
    D's purchases - Cherry, Almonds

    Output:  Cherry, Kiwi
     */

    var productA = new Product("A");
    var productB = new Product("B");
    var productC = new Product("C");
    var productD = new Product("D");

    var userA = new User("A");
    var userB = new User("B");
    var userC = new User("C");
    var userD = new User("D");

    var recommender =
        new ProductRecommender(
            user -> {
              if (user == userB) return List.of(productA, productA, productB, productC);
              if (user == userC) return List.of(productB, productC);
              if (user == userD) return List.of(productC, productD);
              return List.of();
            },
            x -> List.of(userB, userC, userD));

    System.out.println(recommender.getProductsMostPurchasedByFriends(userA, 2));
  }
}
