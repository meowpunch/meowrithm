package Leetcode;

public class BestTimeToBuyAndSellStockIV {
    public static void main(String[] args) {
        System.out.println(
                new BestTimeToBuyAndSellStockIV().maxProfit(2, new int[]{3,3,5,0,0,3,1,4})
        );
    }

    /**
     * dp(i, j) represents maximum profits until prices[i] at most j transactions.
     * dp(i, j) <- max( dp(i-1,j), prices[j] - prices[m] + dp(m, j-1) ) { m}
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {

        return 1;
    }
}
