import sys
from typing import List


class Solution:
    def maxProfit2(self, prices: List[int]) -> int:
        # dp[i][l] i day 날까지 stock 을 가지고 있는 경우(l=1) 가지고 있지 않은 경우(l=0) 최대 profit

        # init
        size = len(prices)
        dp = [[0 for _ in range(2)] for _ in range(size)]
        dp[0][1] = -prices[0]
        dp[0][0] = 0

        for i in range(1, size):
            # 사는 경우
            dp[i][1] = max(dp[i - 1][0] - prices[i], dp[i - 1][1]) if dp[i - 1][0] is 0 else dp[i - 1][1]

            # 파는 경우
            dp[i][0] = max(dp[i - 1][1] + prices[i], dp[i - 1][0])

        max_profit = 0
        print(dp)
        for i in range(size):
            if dp[i][0] > max_profit:
                max_profit = dp[i][0]

        return max_profit

    def maxProfit(self, prices: List[int]) -> int:
        min_val = sys.maxsize
        max_profit = 0

        # idx 까지의 최소를 val 과 빼줘서 최대 profit 을 갱신한다.
        # max_profit(i)은 i 까지의 촤대 profit
        # max_profit(i) = max(prices[i] - min_val, max_profit(i-1)), val >= min_val
        for idx, val in enumerate(prices):
            if val < min_val:
                min_val = val
            else:
                tmp_profit = val - min_val
                if tmp_profit > max_profit:
                    max_profit = tmp_profit

        return max_profit


if __name__ == '__main__':
    sol = Solution().maxProfit(prices=[7, 1, 5, 3, 6, 4])
    print(sol)

    sol = Solution().maxProfit2(prices=[7, 1, 5, 3, 6, 4])
    print(sol)
