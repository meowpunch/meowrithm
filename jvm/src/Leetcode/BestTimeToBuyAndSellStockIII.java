package Leetcode;

public class BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        System.out.println(
                BestTimeToBuyAndSellStockIII.maxProfit(new int[]{3,3,5,0,0,3,1,4})
        );
    }

    public static int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;

        for (int curPrice : prices) {
            if (firstBuy < -curPrice) firstBuy = -curPrice;
            if (firstSell < firstBuy + curPrice) firstSell = firstBuy + curPrice;
            if (secondBuy < firstSell - curPrice) secondBuy = firstSell - curPrice;
            if (secondSell < secondBuy + curPrice) secondSell = secondBuy + curPrice;

            System.out.printf("%s %s %s %s%n", firstBuy, firstSell, secondBuy, secondSell);
        }

        return secondSell;
    }
}
