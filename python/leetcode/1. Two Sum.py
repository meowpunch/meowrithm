from typing import List


class Solution:
    @staticmethod
    def twoSum(nums: List[int], target: int) -> List[int]:
        # value: index
        mem = dict()
        for idx, n in enumerate(nums):
            remain = target - n
            # remain in mem -> O(n)
            # mem.get(remain) -> O(1)
            value = mem.get(remain)
            if value is not None:
                return [value, idx]
            else:
                mem[n] = idx


if __name__ == '__main__':
    print(Solution.twoSum([2, 7, 11, 15], 9))
