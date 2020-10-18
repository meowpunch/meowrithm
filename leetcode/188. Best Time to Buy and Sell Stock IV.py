# Best Time to Buy and Sell Stock IV

# You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
#
# Design an algorithm to find the maximum profit. You may complete at most k transactions.
#
# Notice that you may not engage in multiple transactions simultaneously
# (i.e., you must sell the stock before you buy again).

import sys
from typing import List


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        # dp[i][j][k]:  i 날까지 j번 stock 을 팔았고 현재 stock 을 가지고 있거나(k=1) 가지고 있지 않은(k=0) 경우 최대 profit

        n = len(prices)
        if n == 0:
            return 0

        # 2k > n 인 경우
        # 없으면 TLE
        if 2*k > n:
            return sum(list(filter(lambda e: e > 0, map(lambda x: x[0] - x[1], zip(prices[1:], prices[:-1])))))

        # init
        dp = [[[-1001 for _ in range(2)] for _ in range(k + 1)] for _ in range(n)]
        dp[0][0][0] = 0
        dp[0][0][1] = -prices[0]

        # iter
        # 당일 제외
        for i in range(1, n):
            # 0 ~ k까지 팔 수 있음
            for j in range(k + 1):
                # 가지고 있는 경우 - 사는 경우 / 원래 있는 경우
                dp[i][j][1] = max(dp[i - 1][j][0] - prices[i], dp[i - 1][j][1])

                # 가지고 있지 않은 경우 - 파는 경우 / 원래 없는 경우
                # 팔 수 없는 경우
                if j == 0 or dp[i - 1][j - 1][1] == -1001:
                    dp[i][j][0] = dp[i - 1][j][0]
                # 팔 수 있는 경우
                else:
                    dp[i][j][0] = max(dp[i - 1][j - 1][1] + prices[i], dp[i - 1][j][0])

                # print(dp[i][j][0], dp[i][j][1])

        # print(dp)
        max_profit = 0
        for j in range(0, k + 1):
            max_profit = max(max_profit, dp[n - 1][j][0], dp[n - 1][j][1])
        return max_profit


if __name__ == '__main__':
    # prices = [3, 2, 6, 5, 0, 3]
    # zipped = zip(prices[1:], prices[:-1])
    # for ele in zipped:
    #     print(ele)
    sol = Solution().maxProfit(k=2, prices=[])
    print(sol)

    sol = Solution().maxProfit(k=2, prices=[3, 3, 5, 0, 0, 3, 1, 4])
    print(sol)

    sol = Solution().maxProfit(k=5, prices=[3, 2, 6, 5, 0, 3])
    print(sol)

    sol = Solution().maxProfit(2, [6, 1, 3, 2, 4, 7])
    print(sol)
