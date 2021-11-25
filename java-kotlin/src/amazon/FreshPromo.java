package amazon;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


/**
 * https://leetcode.com/discuss/interview-question/1002811/Amazon-or-OA-20201-or-Fresh-Promotion
 */
public class FreshPromo {
    public static void main(String[] args) {
        Stream.of(
                FreshPromo.foo(
                        Arrays.asList(
                                Arrays.asList("apple", "apple"),
                                Arrays.asList("banana", "anything", "banana")
                        ),
                        Arrays.asList(
                                "apple", "apple", "apple", "banana", "orange", "banana"
                        )
                ),
                FreshPromo.foo(
                        Arrays.asList(
                                Arrays.asList("apple", "apple"),
                                Arrays.asList("banana", "anything", "banana")
                        ),
                        Arrays.asList(
                                "apple", "apple", "apple", "banana", "banana", "apple", "banana"
                        )
                ),
                FreshPromo.foo(
                        Arrays.asList(
                                Arrays.asList("apple", "apple"),
                                Arrays.asList("banana", "anything", "banana")
                        ),
                        Arrays.asList(
                                "apple", "apple", "apple", "banana", "banana", "apple"
                        )
                )
        ).forEach(System.out::println);

    }

    /**
     * we can enhance this method with KMP algorithm
     *
     * @param codeList     [[apple, apple], [banana, anything, banana]]
     * @param shoppingCart [orange, apple, apple, banana, orange, banana]
     * @return 1(match) or 0(not)
     */
    public static int foo(List<List<String>> codeList, List<String> shoppingCart) {
        final int cartSize = shoppingCart.size();
        final int codeListSize = codeList.size();
        int cartIndex = 0;
        int codeIndex = 0;

        while (cartIndex < cartSize && codeIndex < codeListSize) {
            final String curItem = shoppingCart.get(cartIndex);
            final List<String> curCode = codeList.get(codeIndex);

            if ((curCode.get(0).equals(curItem) || curCode.get(0).equals("anything")) &&
                    (cartIndex + curCode.size() <= cartSize && checkMatching(shoppingCart.subList(cartIndex, cartIndex + curCode.size()), curCode))) {
                cartIndex += curCode.size();
                codeIndex += 1;
            } else {
                cartIndex += 1;
            }
        }
        return codeIndex == codeListSize ? 1 : 0;
    }

    private static boolean checkMatching(List<String> cart, List<String> code) {
//        System.out.printf("%s %s\n", cart, code);
        for (int i = 0; i < cart.size(); i++) {
            if (!code.get(i).equals("anything") && !code.get(i).equals(cart.get(i))) return false;
        }
        return true;
    }
}
