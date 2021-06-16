package Codility;

public class MaxProfit {
    /**
     *  Memoization: Time, Space - O(N), O(1)
     */
    public int solution(int[] A) {
        int minStock = 200001;
        int maxProfit = 0;

        for (int stock: A) {
            if (stock < minStock) minStock = stock;
            else maxProfit = Math.max(stock - minStock, maxProfit);
        }

        return maxProfit;
    }
}
