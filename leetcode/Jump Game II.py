"""
DP is smaller search space than BFS

1 <= nums.length (L) <= 1000
0 <= nums[i] (N) <= 10^5
L <<<< N
"""
from collections import deque
from typing import List


class Solution:
    def bfs(self, nums: List[int]) -> int:
        # init stack - (index, depth)
        que = deque()
        que.append((0, 0))
        L = len(nums)
        visited = [False] * L

        if L - 1 == 0:
            return 0

        # BFS
        while len(que) > 0:
            # print(que)
            idx, dep = que.popleft()
            visited[idx] = True
            num = nums[idx]

            # too complex time
            for i in range(1, num + 1):
                nextIdx = idx + i
                if nextIdx < L - 1 and visited[nextIdx] is False:
                    que.append((nextIdx, dep + 1))
                elif nextIdx is L - 1:
                    return dep + 1

    def dp(self, nums: List[int]) -> int:
        """
        dp(i) is minimum number of jumps to i-th element. -1 means it is impossible to reach.
        dp(i) = min{dp(j)} + 1,  i - j <= nums(j) and 0 <= j < i
        """
        # init
        L = len(nums)
        dp = [-1] * L

        # base
        dp[0] = 0

        # loop
        for i in range(1, L):
            minJumps = 1001
            # find minJumps reachable to i
            for j in range(0, i):
                if i - j <= nums[j] and minJumps > dp[j]:
                    minJumps = dp[j] + 1

            dp[i] = minJumps

        return dp[L - 1]

    def jump(self, nums: List[int]) -> int:
        return self.dp(nums)


if __name__ == '__main__':
    assert 2 == Solution().bfs([2, 3, 1, 1, 2])
    assert 2 == Solution().dp([2, 3, 1, 1, 2])
