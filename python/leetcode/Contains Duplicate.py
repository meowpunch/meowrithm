class Solution:

    def hashTable(self, nums: List[int]) -> int:
        """
        time: O(n)
        space: O(n)
        """
        # the count of key's occuring
        table = dict()

        for val in nums:
            table[val] = table.get(val, 0) + 1

        for val in nums:
            if table.get(val) == 1:
                return val

    def bitManipulate(self, nums: List[int]) -> int:
        """
        awesome way
        time: O(n)
        space: constant
        """
        result = 0
        for val in nums:
            result ^= val

        return result

    def nonLinear(self, nums: List[int]) -> int:
        """
        time: O(nlogn)
        space: constant
        """
        # sorting (inplace)
        nums.sort()

        # check duplicates
        currIdx = 0
        while currIdx < len(nums) - 1:

            if nums[currIdx] == nums[currIdx + 1]:
                currIdx += 2
            else:
                return nums[currIdx]

        return nums[-1]

    def singleNumber(self, nums: List[int]) -> int:
        return self.bitManipulate(nums)  # self.hashTable(nums) # self.nonLinear(nums)
