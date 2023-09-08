class Solution:
    def getMaxLen(self, nums: List[int]) -> int:
        ans = pos = neg = 0

        for num in nums:
            if num > 0:
                pos += 1
                if neg > 0:
                    neg += 1
            elif num < 0:
                neg, pos = pos + 1, (neg + 1 if neg > 0 else 0)
            else:
                neg = pos = 0

            ans = max(ans, pos)

        return ans
