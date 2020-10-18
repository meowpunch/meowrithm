class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        # dp[i]: i 번째를 포함하는 최대 부분합
        # dp[i] <- max(dp[i-1] + num[i], num[i])

        # init
        n = len(nums)
        dp = [0 for _ in range(n)]
        dp[0] = nums[0]

        # iter
        for i in range(1, n):
            dp[i] = max(dp[i - 1] + nums[i], nums[i])

        return max(dp)