from typing import List


class Solution:
    @staticmethod
    def twoSum(nums: List[int], n: int) -> List[List[int]]:
        # [1,2,1,3,-1,2,0], 3 -> [[1,2], [0,3]
        answer = list()
        mem = dict()

        for idx, y in enumerate(nums):
            # x + y = n -> x = n - y
            x = mem.get(n - y)

            def removeDuplicates(e):
                for a in answer:
                    if e in a:
                        return False

                return True

            if x is not None:
                if removeDuplicates(x):
                    answer.append([x, y])
            else:
                mem[y] = y

        return answer

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # Input: nums = [-1, 0, 1, 2, -1, -4]
        # Output: [[-1, -1, 2], [-1, 0, 1]]

        # unique triplets
        answer = list()
        mem = dict()

        if len(nums) < 3:
            return answer

        for idx, z in enumerate(nums):
            # x + y + z = 0 -> x + y = -z

            tmp = mem.get(-z)
            if not tmp:
                tmp = self.twoSum(nums[idx + 1:], -z)
                if not tmp:
                    continue

            candidates = map(lambda l: l + [z], tmp)

            # how to distinguish [-1,0,1]  and [0,1,-1]
            def removeDuplicates(b):
                target = set(b)
                for ansEle in answer:
                    if target == set(ansEle):
                        return False
                return True

            filtered = filter(removeDuplicates, candidates)
            answer = answer + list(filtered)
        return answer


if __name__ == '__main__':
    # print(Solution().threeSum([0,0,0]))
    print(Solution().threeSum([-1,0,1,2,-1,-4]))

    # print(Solution().twoSum([1,2,3,-1,1,0], 2))