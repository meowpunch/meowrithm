# 최단경로 개수
# 왼쪽 상단과 오른쪽 하단에 목적지와 도착지가 정해져있고
# 오른쪽과 아래쪽으로만 움직이면 가능한 경로가 무조건 최단 경로임
# 즉 오른쪽과 아래쪽으로만 움직여서 가능한 경로 개수 return

# DFS 로 탐색하면서 가능한 결로를 저장해두자.
# f(i, j) <- f(i-1, j) + f(i, j-1)


def solution(m, n, puddles):
    isPuddle = lambda point: [point[0] + 1, point[1] + 1] in puddles

    # 메모 m x n
    # f = [[0] * m] * n -> 주소복사돼서 안됨
    f = [[0 for _ in range(m)] for _ in range(n)]

    # m=0인 경우
    for row in range(n):
        if isPuddle([0, row]):
            break

        f[row][0] = 1

    # n=0인 경우
    for col in range(m):
        if isPuddle([col, 0]):
            break

        f[0][col] = 1

    for row in range(1, n):
        for col in range(1, m):
            if isPuddle([col, row]):
                continue

            f[row][col] = f[row - 1][col] + f[row][col - 1]

    return f[n-1][m-1] % 1000000007


if __name__ == '__main__':
    print(solution(4, 3, [[2, 2]]))
