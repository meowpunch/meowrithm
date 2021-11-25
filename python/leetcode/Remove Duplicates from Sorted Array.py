from typing import List


class Solution:
    def wrongAnswer(self, nums: List[int]) -> int:
        """
        It removes the duplicates not in place.
        """

        def removeElementByIndex(arr: List[int], index: int) -> int:
            return arr[0:index] + arr[index + 1:len(arr)]

        # init
        prevValue = None
        currIndex = 0
        currLength = len(nums)

        while currIndex < len(nums):
            # you can see the address changing.
            print(hex(id(nums)))
            currValue = nums[currIndex]

            if prevValue == currValue:
                nums = removeElementByIndex(nums, currIndex)
                currLength -= 1
            else:
                currIndex += 1

            prevValue = currValue

        return currLength

    def inplaceAnswer(self, nums: List[int]) -> int:
        # L == 0
        if len(nums) == 0:
            return 0

        # init
        length = 1

        # L >= 1
        for currIndex in range(1, len(nums)):
            if nums[currIndex - 1] != nums[currIndex]:
                nums[length] = nums[currIndex]
                length += 1

        return length

    def removeDuplicates(self, nums: List[int]) -> int:
        return self.inplaceAnswer(nums)

