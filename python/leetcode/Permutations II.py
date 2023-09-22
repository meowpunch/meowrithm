class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        return self.permute(nums)

    # 00019
    # 0
    #
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 1:
            return [[nums[0]]]

        res = list()
        prev = None
        for num in nums:
            if prev is not None and prev == num:
                continue
            copy = nums.copy()
            copy.remove(num)
            for p in self.permute(copy):
                p = [num] + p
                res.append(p)

            prev = num

        return res
