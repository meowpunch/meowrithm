class Solution:
    def climbStairs(self, n: int) -> int:
        # dp(i) = dp(i - 1) + dp(i - 2)

        dp = [0] * 47

        dp[1] = 1
        dp[2] = 2

        if n < 3:
            return dp[n]
        else:
            for i in range(3, n + 1):
                dp[i] = dp[i - 1] + dp[i - 2]

        return dp[n]
