# 1. DFS 로 탐색하면서 메모하기
# 2. depth 를 기준으로 돌면서 메모하기
# 시간복잡도는 같으므로 구현이 쉬운 2번 방식으로 채택


def solution(triangle):
    # 깊이
    max_depth = len(triangle)

    # 메모할 곳 만들기
    f = [[0] * (d + 1) for d in range(max_depth)]

    # 초기화
    f[0][0] = triangle[0][0]

    # 초기 탈출 - depth 가 1인 경우
    if max_depth == 1:
        return f[0][0]

    # 깊이 기준으로 채워 넣기
    for depth in range(1, max_depth):
        # f(d, 0) <- f(d-1, 0) + triangle(d, 0)
        f[depth][0] = f[depth - 1][0] + triangle[depth][0]

        # f(d, i) <- max( f(d-1, i-1), f(d-1, i) ) + triangle(d, i)
        for i in range(1, depth):
            f[depth][i] = max(f[depth - 1][i - 1], f[depth - 1][i]) + triangle[depth][i]

        # f(d, d) <- f(d-1, d-1) + triangle(d, d)
        f[depth][depth] = f[depth - 1][depth - 1] + triangle[depth][depth]

    return max(f[max_depth - 1])


if __name__ == '__main__':
    print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))
