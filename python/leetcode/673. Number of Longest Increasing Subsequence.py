class Solution:
    def findNumberOfLIS(self, nums: List[int]) -> int:
        size = len(nums)

        if size == 0 or size == 1:
            return size

        # dp(i, 0) : size of longest increasing subseq including i-th element.
        # dp(i, 1) : number of longest increasing subseq including i-th element.
        dp = [[1, 1] for _ in range(size)]
        # dp[0][0], dp[0][1] = 1, 1

        for i in range(1, size):
            size = 0
            number = 0
            for j in range(i):
                # always j < i
                if nums[j] < nums[i]:
                    if size < dp[j][0]:
                        size = dp[j][0]
                        number = dp[j][1]
                    elif size == dp[j][0]:
                        number += dp[j][1]

            if size > 0:
                dp[i][0] = size + 1
                dp[i][1] = number

        print(dp)

        sorted_dp = sorted(dp, key=lambda x: x[0], reverse=True)
        max_size = sorted_dp[0][0]

        return sum(map(lambda x: x[1], filter(lambda d: d[0] == max_size, sorted_dp)))
