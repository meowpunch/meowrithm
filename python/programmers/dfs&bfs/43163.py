# 단어 길이가 길다면 항상 함수호출하는 것이 아니라
# 연결 관계 그래프를 한번 그려주고 저장한 후 시작하는 게 유리할 듯 -> 저장해야함 시간초과 문제

# [x != y for x, y in zip(l, r)]
from collections import deque

isChangeable = lambda l, r: sum(map(lambda x, y: x != y, l, r)) == 1


# 최단 거리는 bfs 가 이득
def solution(begin, target, words):
    # 시작 노드도 넣어줌
    words.append(begin)
    visited = [False] * len(words)

    # 가능한 애들 정리해줌
    connected = dict()
    # 인덱스 저장 value : index
    mem_idx = dict()

    for idx, word in enumerate(words):
        mem_idx[word] = idx
        connected[word] = set(filter(lambda w: isChangeable(w, word), words))

    print(connected)
    # node and level
    queue = deque()
    queue.append((begin, 0))

    while len(queue) > 0:
        # queue 에서 꺼낸다.
        cur, level = queue.popleft()
        print(queue, cur)

        # 방문한다.
        visited[mem_idx.get(cur)] = True

        # 방문 노드의 접근 가능한 노드들을 넣는다.
        for candidate in connected[cur]:
            if not visited[mem_idx.get(candidate)]:
                if candidate == target:
                    return level + 1
                else:
                    queue.append((candidate, level + 1))

    return 0


if __name__ == '__main__':
    print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))
    print(solution(begin="hit", target="hhh", words=["hhh", "hht"]))
