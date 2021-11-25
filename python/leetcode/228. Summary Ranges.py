class Solution:
    def make_str(self, nums: List[int]) -> str:
        if len(nums) == 1:
            return str(nums[0])
        else:
            return str(nums[0]) + "->" + str(nums[-1])

    def summaryRanges(self, nums: List[int]) -> List[str]:

        ranges = []
        continuous_nums = []

        for num in nums:
            if not continuous_nums:
                continuous_nums.append(num)
            elif continuous_nums[-1] + 1 == num:
                continuous_nums.append(num)
            else:
                # stringified = self.make_str(continuous_nums)
                # ranges.append(stringified)
                ranges.append(continuous_nums)
                continuous_nums = [num]

        if continuous_nums:
            ranges.append(continuous_nums)

        return list(map(self.make_str, ranges))
