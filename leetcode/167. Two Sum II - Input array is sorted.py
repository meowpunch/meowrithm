class Solution:
    @staticmethod
    def twoSum(nums: List[int], target: int) -> List[int]:
        left, right = 0, len(nums) - 1

        while left < right:
            summation = nums[left] + nums[right]

            if summation == target:
                return [left + 1, right + 1]
            elif summation > target:
                right -= 1
            else:
                left += 1

        return False

