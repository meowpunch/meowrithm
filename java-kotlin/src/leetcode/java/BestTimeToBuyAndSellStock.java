package leetcode.java;

public class BestTimeToBuyAndSellStock {

  /*
      7
                      6
              5
                          4
                  3

          1

      7   1   1   1   1   1   min - bestBuyingPrice
      0   0   4   2   5   3   possible profit

      7
                      6
              5
                          4
          3

                  1

      7   3   3   1   1   1   min
      0   0   2   0   5   3   possible profit


      7   6   4   3   1

      7   6   4   3   1   min
      0   0   0   0   0   possible profit

   */
  public int maxProfit(int[] prices) {
    int bestBuyingPrice = Integer.MAX_VALUE;
    int possibleProfit = 0;
    int maxProfit = 0;

    for (int price : prices) {
      if (price < bestBuyingPrice) {
        // buy
        bestBuyingPrice = price;
      } else {
        // sell
        possibleProfit = price - bestBuyingPrice;
        if (maxProfit < possibleProfit) {
          maxProfit = possibleProfit;
        }
      }
    }

    return maxProfit;
  }

  /*
      7
                      6
              5
                          4
                  3

          1
      7   6   6   6   6   4   maxFromRight
      7   1   1   1   1   1   minFromLeft

      7
                      6
              5
                          4
          3

                  1

      7   6   6   6   6   4   maxFromRight
      7   3   3   1   1   1   minFromLeft


      7   6   4   3   1
      7   6   4   3   1   maxFromRight
      7   6   4   3   1   minFromLeft
   */
  private int maxProfitWithExtraSpace(int[] prices) {
    final int N = prices.length;
    var maxFromRight = new int[N];
    var minFromLeft = new int[N];

    minFromLeft[0] = prices[0];
    for (int i = 1; i < N; i++) {
      minFromLeft[i] = Math.min(minFromLeft[i - 1], prices[i]);
    }

    maxFromRight[N - 1] = prices[N - 1];
    for (int i = N - 2; i >= 0; i--) {
      maxFromRight[i] = Math.max(maxFromRight[i + 1], prices[i]);
    }

    int profit = 0;
    for (int i = 0; i < N; i++) {
      profit = Math.max(maxFromRight[i] - minFromLeft[i], profit);
    }

    return profit;
  }
}
