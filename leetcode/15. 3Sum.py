from typing import List


class Solution:
    @staticmethod
    def twoSum(nums: List[int], n: int) -> List[List[int]]:
        # [1,2,1,3,-1,2,0], 3 -> [[1,2], [0,3]
        answer = list()

        for idx, y in enumerate(nums):
            # x + y = n -> x = n - y
            for x in nums[idx + 1:]:
                if x == n - y:
                    def removeDuplicates(e):
                        for a in answer:
                            if e in a:
                                return False

                        return True

                    if removeDuplicates(x):
                        answer.append([x, y])

        return answer

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # Input: nums = [-1, 0, 1, 2, -1, -4]
        # Output: [[-1, -1, 2], [-1, 0, 1]]

        # unique triplets
        answer = list()

        if len(nums) < 3:
            return answer

        for idx, z in enumerate(nums):
            # x + y + z = 0 -> x + y = -z

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
    print(Solution().threeSum([0,0,0]))