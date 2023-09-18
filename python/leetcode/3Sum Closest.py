class Solution:
    @staticmethod
    def twoSumCloset(sorted_nums: List[int], target: int) -> int:
        lp, rp = 0, len(sorted_nums) - 1

        cloest_sum = sorted_nums[lp] + sorted_nums[rp]
        while lp < rp:
            cur_sum = sorted_nums[lp] + sorted_nums[rp]

            if abs(target - cur_sum) < abs(target - cloest_sum):
                cloest_sum = cur_sum

            if cur_sum > target:
                rp -= 1
            else:
                lp += 1

        return cloest_sum

    def threeSumClosest(self, nums: List[int], target: int) -> int:
        N = len(nums)
        nums.sort()

        closet_sum = nums[0] + nums[1] + nums[2]
        for i in range(N - 2):
            cur_sum = nums[i] + self.twoSumCloset(nums[i + 1:],
                                                  target - nums[i])
            if abs(target - cur_sum) < abs(target - closet_sum):
                closet_sum = cur_sum

        return closet_sum
