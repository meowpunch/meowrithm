class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
        # DP
        # TC - O(n)
        # SC - O(1)
        dp1 = None
        dp2 = None

        for num in nums:
            # for dp1
            if dp1 is not None and num > dp1:
                # for dp2
                if dp2 is not None and num > dp2:
                    return True
                else:
                    dp2 = num
            else:
                dp1 = num

        return False
