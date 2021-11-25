class Solution:
    def memoziation(self, nums: List[int], target: int) -> List[int]:
        mem = dict()
        for i, v in enumerate(nums):
            j = mem.get(v, -1)
            if j >= 0:
                return [i, j]
            else:
                mem[target - v] = i

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        return self.memoziation(nums, target)