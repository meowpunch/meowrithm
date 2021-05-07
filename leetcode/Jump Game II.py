"""
BFS
"""
from collections import deque
from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:

        # init stack - (index, depth)
        que = deque()
        que.append((0, 0))
        L = len(nums)
        visited = [False] * L

        if L - 1 is 0:
            return 0

        # BFS
        while len(que) > 0:
            # print(que)
            idx, dep = que.popleft()
            visited[idx] = True
            num = nums[idx]

            for i in range(1, num + 1):
                nextIdx = idx + i
                if nextIdx < L - 1 and visited[nextIdx] is False:
                    que.append((nextIdx, dep + 1))
                elif nextIdx is L - 1:
                    return dep + 1
