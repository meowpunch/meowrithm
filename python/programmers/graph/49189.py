# BFS로 한번 훑으면 끝
# depth가 가장 큰 노드가 몇개인가?
from collections import deque


def solution(n, edge):
    # 맵핑해주기
    # 노드 시작 인덱스는 무의미하므로 편하게 0으로 맞춰줌
    # key is connected value
    connected = dict()
    for idx in range(n):
        connected[idx] = []

    for e in edge:
        connected[e[0] - 1] += [e[1] - 1]
        connected[e[1] - 1] += [e[0] - 1]

    # 탐색여부
    searched = [False] * n

    # 0에서 시작(문제에서는 1) (node, depth)
    q = deque()
    q.append((0, 0))

    result = [0]
    searched[0] = True

    # 다 탐색하면 탈출
    while len(result) < n:

        # 방문한다
        cur, depth = q.popleft()

        # 연결된 노드 중에 방문안된 노드 추가
        # 이미 q에 있으면 추가안함
        for tar in connected[cur]:
            if not searched[tar]:
                searched[tar] = True
                q.append((tar, depth + 1))
                result.append(depth + 1)

    return result.count(max(result))


if __name__ == '__main__':
    print(solution(n=6, edge=[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]))
