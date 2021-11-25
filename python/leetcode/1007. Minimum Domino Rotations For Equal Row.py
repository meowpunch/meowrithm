from typing import List


class Solution:
    def minDominoRotations2(self, A: List[int], B: List[int]) -> int:
        # dp[i][j][k] k 번째까지 봤을때, A에서 맞추는 경우(j=0), B에서 맞추는 경우(j=1),
        # A[0]로 맞추는 경우(i=0), A[1]로 맞추는 경우(i=1) 로테이트 수
        # List 의 size 가 n 일때, 4*n 만큼 탐색해야함 즉 O(n)

        n = len(A)
        # 조건에 n >= 2이긴 함
        if n == 1:
            return 0

        dp = [[[-1 for _ in range(n)] for _ in range(2)] for _ in range(2)]

        # A에서 A[0]로 맞춤
        dp[0][0][0] = 0
        # A에서 B[0]로 맞춤
        dp[1][0][0] = 1

        # B에서 A[0]로 맞춤
        dp[0][1][0] = 1
        # B에서 B[0]로 맞춤
        dp[1][1][0] = 0

        def memo(tmp_dp: List[int], std_num: int, std_list: List[int], ref_list: List[int]) -> List[int]:
            # std_list 에서 std_num 기준으로 맞춰 채운다.

            for i in range(1, n):

                # 맞춰나가기 가능한 경우
                if tmp_dp[i - 1] != -1:
                    # 그대로 유지
                    if std_num == std_list[i]:
                        tmp_dp[i] = tmp_dp[i - 1]
                    # rotate
                    elif std_num == ref_list[i]:
                        tmp_dp[i] = tmp_dp[i - 1] + 1
                # 불가능한 경우
                else:
                    break
            print(tmp_dp)
            return tmp_dp

        res = [memo(dp[0][0], A[0], A, B)[-1], memo(dp[1][0], B[0], A, B)[-1], memo(dp[0][1], A[0], B, A)[-1],
               memo(dp[1][1], B[0], B, A)[-1]]
        filtered = list(filter(lambda r: r != -1, res))

        if len(filtered) == 0:
            return -1
        else:
            return min(filtered)


if __name__ == '__main__':
    sol = Solution().minDominoRotations([3, 5, 1, 2, 3], [3, 6, 3, 3, 4])
    print(sol)
