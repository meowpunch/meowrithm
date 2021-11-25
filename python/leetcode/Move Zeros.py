class Solution:
    def firstMySolution(self, nums: List[int]) -> None:
        toFillIndex, currentIndex = 0, 0
        length = len(nums)

        while currentIndex < length:
            # print(currentIndex, toFillIndex, nums)
            if nums[toFillIndex] == 0:

                while nums[currentIndex] == 0:
                    currentIndex += 1
                    if currentIndex >= length:
                        return

                nums[toFillIndex] = nums[currentIndex]
                nums[currentIndex] = 0

                toFillIndex += 1
            else:
                toFillIndex += 1
                currentIndex += 1

    def afterOptimizing(self, nums: List[int]) -> None:
        toFillIndex = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                # swap
                temp = nums[toFillIndex]
                nums[toFillIndex] = nums[i]
                nums[i] = temp
                toFillIndex += 1

    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.

        two pointers
        time: linear
        space: constant
        """
        self.afterOptimizing(nums)