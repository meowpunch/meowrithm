# 1 4 9 16 25 36 49

# 1 True
# 2 False
# 3 True
# 4 True
# 5 False
# 6 True
# 25 True
# 26 True - 16 9 1 / 16 4 1 4 1 / 16 1 9
from functools import lru_cache


class Solution:
    def winnerSquareGame2(self, n: int) -> bool:
        if n == 1:
            return True

        # dp로 가자
        dp = [False for _ in range(n + 1)]
        dp[1] = True

        for i in range(2, 1 + n):
            # j까지의 제곱수
            j = 1
            while j ** 2 <= i:
                if j ** 2 == i or not dp[i - j ** 2]:
                    dp[i] = True
                    break

                j += 1

        # print(dp)

        return dp[n]

    # DFS로 search space를 최적화 해보자
    # iteration을 통해 모두 메모해서 가는 것이 아니라
    # DFS로 탐색에 필요한 것만 찾아서 메모제이션 한다.
    def winnerSquareGame3(self, n: int) -> bool:

        # dp lru cache
        @lru_cache(None)
        def DFS(position):
            if position == 0:
                return False

            i = 1
            while i ** 2 <= position:
                if not DFS(position - i ** 2):
                    return True

                i += 1

            return False

        return DFS(position=n)

    def winnerSquareGame(self, n: int) -> bool:

        dp = [None for _ in range(n + 1)]

        def DFS(position):
            if position == 0:
                return False

            i = 1
            while i ** 2 <= position:
                target = position - i ** 2
                if dp[target] is None:
                    dp[target] = DFS(target)

                if not dp[target]:
                    return True

                i += 1

            return False

        return DFS(position=n)
