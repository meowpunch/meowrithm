class Solution:

    def bruteForce(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k = k % n

        for i in range(k):
            prev = nums[-1]
            for j in range(n):
                nums[j], prev = prev, nums[j]

    def cyclicReplacement(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k %= n

        start, count = 0, 0

        # SELF_FEEDBACK: come up with a terminal point!
        while count < n:
            # do while
            currIdx, currVal = start, nums[start]
            while True:
                nextIdx = (currIdx + k) % n

                # replace
                tempVal = nums[nextIdx]
                nums[nextIdx] = currVal

                currVal = tempVal
                currIdx = nextIdx
                count += 1

                if currIdx == start:
                    break

            start += 1

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.

        time: O(n)
        space: O(1)
        """
        self.bruteForce(nums, k)
        # self.cyclicReplacement(nums, k)
