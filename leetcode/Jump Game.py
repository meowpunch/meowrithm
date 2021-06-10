class Solution:
    def spaceLinear(self, nums):
        """
        dp(i): The number of left jump

        dp(i) <- max(dp(i - 1) - 1, num(i))
        """
        dp = dict()

        for i, v in enumerate(nums):
            # base case
            if i == 0:
                dp[i] = nums[0]
            else:
                if dp[i - 1] > 0:
                    dp[i] = max(dp[i - 1] - 1, nums[i])
                else:
                    return False

        return True

    def spaceConstant(self, nums):
        leftover = nums[0]

        for i in range(1, len(nums)):
            if leftover > 0:
                leftover = max(leftover - 1, nums[i])
            else:
                return False

        return True

    def canJump(self, nums: List[int]) -> bool:
        return self.spaceConstant(nums)
