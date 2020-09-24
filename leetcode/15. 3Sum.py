import itertools
from typing import List


class Solution:
    @staticmethod
    def twoSum(nums: List[int], target: int) -> List[int]:
        print('list: {}, target: {}'.format(nums, target))
        # answer = [1, 2]

        # value: index
        mem = dict()
        for idx, n in enumerate(nums):
            remain = target - n
            if remain in mem.keys():
                return [remain, n]
            else:
                mem[n] = idx

        return -1

    def threeSum(self, nums: List[int]) -> List[List[int]]:

        result = []
        mem = dict()

        # for idx, num in enumerate(nums):
        #     mem[num] =

        for idx, n in enumerate(nums):
            temp = nums.copy()
            temp.remove(n)
            res = self.twoSum(temp, -1 * n)
            print(res)
            if res == -1:
                continue
            else:
                result.append([n] + res)

        return result


if __name__ == '__main__':
    print(Solution().threeSum([-1, 0, 1, 2, -1, -4]))
