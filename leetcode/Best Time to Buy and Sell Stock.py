class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # dp[i] is maximum of profit at i days
        # dp[i] = max(f(i) - f(i - 1) + dp[i - 1], 0)
        n = len(prices)
        dp = [0] * n

        for day in range(n):
            if day is 0:
                dp[0] = 0
                continue

            dp[day] = max(prices[day] - prices[day - 1] + dp[day - 1], 0)

        return max(dp)