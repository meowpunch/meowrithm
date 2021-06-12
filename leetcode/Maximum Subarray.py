class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        """

        dp(i) is the largest sum of the contiguous subarray including last index i

        dp(i) <- max(dp(i - 1) + i, i)
        """
        dp = dict()
        for i in range(len(nums)):
            if i == 0:
                dp[i] = nums[i]
            else:
                dp[i] = max(dp[i - 1] + nums[i], nums[i])

        return max(dp.values())