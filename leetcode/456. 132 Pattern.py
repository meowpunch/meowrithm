from itertools import accumulate
from typing import List


class Solution:

    def find132pattern(self, nums: List[int]) -> bool:
        n = len(nums)
        if n == 1 or n == 2:
            return False

        # min_dp[i]는 i를 봤을때 0 ~ i까지의 최소값
        # 점점 값이 작거나 같을 것임
        min_dp = list(accumulate(nums, min))

        # 중간에 올 수있는 후보군 (내림차순 정렬됨)
        mid_dp = [nums[n - 1]]

        for i in range(n - 2, 0, -1):
            # 후보군 걸러내기
            mid_dp = list(filter(lambda x: x > min_dp[i - 1], mid_dp))

            if mid_dp and mid_dp[-1] < nums[i]:
                return True

            if min_dp[i - 1] < nums[i]:
                mid_dp.append(nums[i])

        return False
