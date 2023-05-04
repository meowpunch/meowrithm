package company.Klarna;

import java.util.*;

class Smoothie {

  private static final Map<String, List<String>> MENU_OPTIONS = Map.ofEntries(
      Map.entry("Classic", List.of("strawberry", "banana", "pineapple", "mango", "peach", "honey")),
      Map.entry("Freezie", List.of("blueberry", "black currant", "grape juice", "frozen yogurt")),
      Map.entry("Greenie", List.of("green apple", "lime", "avocado", "spinach", "ice", "apple juice")),
      Map.entry("Just Desserts", List.of("banana", "ice cream", "chocolate", "peanut", "cherry"))
  );

  public static String ingredients(String order) {
    final var translatedOrder = translateOrder(order);
    final var ingredients = MENU_OPTIONS.getOrDefault(translatedOrder.menuName, Collections.emptyList());
    return ingredients.stream()
        .filter(ingredient -> !translatedOrder.ingredientsToBeOmitted.contains(ingredient))
        .sorted()
        .reduce((l, r) -> l + "," + r)
        .orElse("");
  }

  private record Order(String menuName, List<String> ingredientsToBeOmitted) {

  }

  private static Order translateOrder(String order) {
    if (order == null) {
      throw new IllegalArgumentException("Order should be not null");
    }

    String menuName = null;
    final var ingredientsToBeOmitted = new ArrayList<String>();
    for (String s : order.split(",")) {
      if (s.startsWith("-")) {
        ingredientsToBeOmitted.add(s.substring(1));
      } else {
        if (!MENU_OPTIONS.containsKey(s)) {
          throw new IllegalArgumentException("%s is invalid part of order".formatted(s));
        }

        menuName = s;
      }
    }

    return new Order(menuName, ingredientsToBeOmitted);
  }
}

