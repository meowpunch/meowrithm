package company.zalando;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.*;

public class BatchingOrders {
  /*
     maximize order not item

     item [1, 2, 3, 2, 4]
     orders = [
         [1, 2],
         [2, 3],
         [3, 4]
         [2],
         [3]
     ]

     countByItem {1=1, 2=2, 3=1, 4=1}

     returns [[1,2],[2,3]] OR [[1,2], [2], [3, 4]]

     Map<Integer(Item), Integer(count)>
  */
  public static List<List<Integer>> maximalSet(List<Integer> items, List<List<Integer>> orders) {
    final Map<Integer, Long> countByItemInStock = getCountByItem(items);

    return orders.stream()
        .filter(
            order -> {
              final Map<Integer, Long> countByItemInOrder = getCountByItem(order);
              if (isPossibleToBePicked(countByItemInOrder, countByItemInStock)) {
                countByItemInOrder.forEach(
                    (item, numOfOrder) -> {
                      final long numOfStock = countByItemInStock.getOrDefault(item, 0L);
                      countByItemInStock.put(item, numOfStock - numOfOrder);
                    });
                return true;
              } else {
                return false;
              }
            })
        .toList();
  }

  /*
     order -> co
  */
  private static boolean isPossibleToBePicked(
      Map<Integer, Long> countByItemInOrder, Map<Integer, Long> countByItemInStock) {
    return countByItemInOrder.entrySet().stream()
        // at least one order can not be fulfilled by stock.
        .allMatch(entry -> countByItemInStock.getOrDefault(entry.getKey(), 0L) >= entry.getValue());
  }

  private static Map<Integer, Long> getCountByItem(List<Integer> items) {
    return items.stream()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static void main(String[] args) {
    List<Integer> items = Arrays.asList(1, 2, 3, 2, 4);
    System.out.println(getCountByItem(items));

    List<List<Integer>> orders =
        Arrays.asList(
            Arrays.asList(1, 2),
            Arrays.asList(2, 3),
            Arrays.asList(3, 4),
            Arrays.asList(2),
            Arrays.asList(3));
    System.out.println(maximalSet(items, orders));
  }
}
