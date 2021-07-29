package Amazon;
import java.util.List;

public class FreshPromo {

    /**
     * @param codeList [[apple, apple], [banana, anything, banana]]
     * @param shoppingCart [orange, apple, apple, banana, orange, banana]
     * @return 1(match) or 0(not)
     */
    public static int foo(List<List<String>> codeList, List<String> shoppingCart) {
        final int cartSize = shoppingCart.size();
        int cartIndex = 0;
        int codeIndex = 0;

        while(cartIndex < cartSize) {

            List<String> code = codeList.get(codeIndex);

            // check if code in shoppingCart
            for (String item: code) {
                if (!item.equals("anything")) {
                    final int index = shoppingCart.subList(cartIndex, cartSize + 1).indexOf(item);
                    if (index > 0) cartIndex = index + 1;
                    else return 0;
                }

                cartIndex++;
            }


            // increment index
        }
        return 1;
    }
}
