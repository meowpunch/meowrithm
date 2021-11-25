class Solution:
    def countArrangement(self, n: int) -> int:

        def dfs(n: int, arr: list = [], ):
            curNum = len(arr) + 1

            # base
            if curNum > n:
                return 1

            sum = 0
            for i in range(1, n + 1):
                if i not in arr and (curNum % i is 0 or i % curNum is 0):
                    sum += dfs(n, arr + [i])

            return sum

        return dfs(n)