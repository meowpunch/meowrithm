class Solution:

    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        N = len(nums)
        nums.sort()

        def twoSum(sorted_nums: List[int], target: int) -> List[List[int]]:
            N = len(sorted_nums)

            res = list()
            lp, rp = 0, N - 1
            while lp < rp:
                if sorted_nums[lp] + sorted_nums[rp] == target:
                    res.append([sorted_nums[lp], sorted_nums[rp]])

                while 1 < lp and lp < rp and sorted_nums[lp - 1] == sorted_nums[
                    lp] == sorted_nums[lp + 1]:
                    lp += 1

                while lp < rp and rp < N - 1 and sorted_nums[rp - 1] == \
                    sorted_nums[
                        rp] == sorted_nums[rp + 1]:
                    rp -= 1

                if sorted_nums[lp] + sorted_nums[rp] >= target:
                    rp -= 1
                else:
                    lp += 1

            return res

        def threeSum(sorted_nums: List[int], target: int) -> List[List[int]]:
            N = len(sorted_nums)

            l = list()
            for i in range(N - 2):
                if i > 0 and sorted_nums[i - 1] == sorted_nums[i]:
                    continue

                for two_sum in Solution.twoSum(sorted_nums[i + 1:],
                                               target - sorted_nums[i]):
                    two_sum.append(sorted_nums[i])
                    l.append(two_sum)

        return l
        s = set()
        for i in range(N - 3):
            if i > 0 and nums[i - 1] == nums[i]:
                continue

            for three_sum in Solution.threeSum(nums[i + 1:], target - nums[i]):
                three_sum.append(nums[i])
                s.add(tuple(three_sum))

        return [list(t) for t in s]
