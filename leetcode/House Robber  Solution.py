class Solution:
    def rob(self, nums: List[int]) -> int:
        """

        dp(i) the maximum amount of robbing money including i-th house

        dp(i) <- max(dp(i - 2) + nums(i), dp(i - 3) + nums(i))
        """

        n = len(nums)
        dp = dict()

        for i in range(n):
            if i == 0:
                dp[i] = nums[0]
            elif i == 1:
                dp[i] = max(nums[0], nums[1])
            elif i == 2:
                dp[i] = max(nums[0] + nums[2], nums[1])
            else:
                dp[i] = max(dp[i - 2] + nums[i], dp[i - 3] + nums[i])

        return max(dp.values())