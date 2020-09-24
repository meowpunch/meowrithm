import sys


def solution(n, s, a, b, fares):
    INF = sys.maxsize
    cost = [[INF for _ in range(n + 1)] for _ in range(n + 1)]

    # 초기화
    for fare in fares:
        cost[fare[0]][fare[1]] = fare[2]
        cost[fare[1]][fare[0]] = fare[2]

    for k in range(1, n + 1):
        for i in range(1, n + 1):
            for j in range(1, n + 1):
                if i == j:
                    cost[i][j] = INF
                else:
                    cost[i][j] = min(cost[i][j], cost[i][k] + cost[k][j])

    min_value = cost[s][a] + cost[s][b]
    for t in range(1, n+1):
        if min_value > cost[s][t] + cost[t][b] + cost[t][a]:
            min_value = cost[s][t] + cost[t][b] + cost[t][a]

    return min_value


if __name__ == '__main__':
    sol = solution(6, 4, 6, 2,
                   [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22],
                    [1, 6, 25]])
    print(sol)
