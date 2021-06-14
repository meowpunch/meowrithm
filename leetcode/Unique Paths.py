class Solution:
    def factorial(self, n, x=1):
        if n == 0:
            return 1 * x

        return self.factorial(n - 1, n * x)

    def combination(self, m, n):
        return self.factorial(m + n - 2) // (self.factorial(n - 1) * self.factorial(m - 1))

    def dynamic(self, m, n):
        """
        dp(i, j) = dp(i - 1, j) + dp(i, j -1)
        """
        dp = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    dp[i][j] = 1
                else:
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        return dp[m - 1][n - 1]

    def uniquePaths(self, m: int, n: int) -> int:
        return self.dynamic(m, n)
        # return self.combination(m, n)