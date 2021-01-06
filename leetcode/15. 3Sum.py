from typing import List


class Solution:
    @staticmethod
    def twoSum(nums: List[int], n: int) -> List[List[int]]:
        # for sorted list
        answer = list()

        # two pointers
        left, right = 0, len(nums) - 1
        while left < right:
            leftV, rightV = nums[left], nums[right]
            summation = leftV + rightV

            if summation == n:
                answer.append([leftV, rightV])

                left += 1
                while left < right and leftV == nums[left]:
                    left += 1

            elif summation > n:
                right -= 1
            elif summation < n:
                left += 1

        return answer

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # Input: nums = [-1, 0, 1, 2, -1, -4]
        # Output: [[-1, -1, 2], [-1, 0, 1]]

        # unique triplets
        answer = list()

        nums.sort()

        for idx, z in enumerate(nums):
            # x + y = -z

            # prevent duplication
            if idx > 0 and z == nums[idx - 1]:
                continue

            for candidate in self.twoSum(nums[idx + 1:], -z):
                answer.append(candidate + [z])

        return answer


if __name__ == '__main__':
    print(Solution().threeSum([0,0,0]))
    print(Solution().threeSum([-1,0,1,2,-1,-4]))

    # print(Solution().twoSum([1,2,3,-1,1,0], 2))