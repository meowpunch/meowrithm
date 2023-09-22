class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 1:
            return [[nums[0]]]

        res = list()
        for num in nums:
            copy = nums.copy()
            copy.remove(num)
            for p in self.permute(copy):
                p.append(num)
                res.append(p)

        return res
