from typing import List


class Solution:
    @staticmethod
    def twoSum(nums: List[int], k: int) -> List[List[int]]:
        r = []
        s = set()
        for num in nums:
            if k - num in s:
                r.append([num, k - num])
            else:
                s.add(num)

        return r

    #
    def threeSum(self, nums: List[int]) -> List[List[int]]:

        s = set()
        for i, v in enumerate(nums):
            for l in self.twoSum(nums[i + 1:], -v):
                l.append(v)
                l.sort()
                s.add(tuple(l))

        return [list(t) for t in s]
