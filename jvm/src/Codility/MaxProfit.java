package Codility;

public class MaxProfit {

    /**
     * diffs of A
     * e.g. A = {3, 2, 1, 5} -> {-1, -1, 4}
     * <p>
     * so maximum sum of consecutive sub array on diff of A
     */
    public int solution(int[] A) {
        int globalMax = 0;
        int localMax = 0;

        for (int i = 1; i < A.length; i++) {
            final int diff = A[i] - A[i - 1];
            localMax = Math.max(localMax, 0) + diff;
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }

    /**
     * Memoization: Time, Space - O(N), O(1)
     */
    public int solution1(int[] A) {
        int minStock = 200001;
        int maxProfit = 0;

        for (int stock : A) {
            if (stock < minStock) minStock = stock;
            else maxProfit = Math.max(stock - minStock, maxProfit);
        }

        return maxProfit;
    }
}
