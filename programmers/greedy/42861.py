# 아무 곳에서 시작해도 됨
# 현재 이어진 노드에서 가능한 연결 안된 노드랑 연결할 수 있는 다리 중 cost가 가장 짧은 것을 택함
# PriorityQueue에 연결 가능한 노드를 넣고 뽑으면 됨

from queue import PriorityQueue


def solution(n, costs):
    # 맵핑하기
    bridges = dict()
    for node in range(n):
        bridges[node] = []

    # node : (cost, target)
    for cost in costs:
        bridges[cost[0]] += [(cost[2], cost[1])]
        bridges[cost[1]] += [(cost[2], cost[0])]

    print(bridges)
    connected = set()  # 연결된 노드들
    candidates = PriorityQueue()  # 후보 bridge 들

    # temp: first bridge, temp[0]: start node
    temp = min(costs, key=lambda x: x[2])
    print(temp)
    candidates.put((temp[2], temp[1]))
    connected.add(temp[0])

    result = 0
    while len(connected) < n:
        # 연결하기 - target 추가 cost 추가
        cur_bridge = candidates.get()
        if cur_bridge[1] in connected:
            # 이미 추가돼있으면 스킵
            continue
        connected.add(cur_bridge[1])
        result += cur_bridge[0]

        # 가능한 후보 bridge 추가하기
        for node in connected:
            temp_bridges = bridges[node]
            # 연결안된 노드들과 연결된 브릿지 추가
            for temp in temp_bridges:
                cost, target = temp
                if target not in connected:
                    # print('put {} from {}'.format(temp, node))
                    candidates.put(temp)

    # print(connected)
    return result


if __name__ == '__main__':
    # print(solution(4, [[0, 1, 1], [0, 2, 2], [1, 2, 5], [1, 3, 1], [2, 3, 8]]))
    # print(solution(2, [[0, 1, 1]]))
    print(solution(n=5, costs=[[0, 1, 5], [1, 2, 3], [2, 3, 3], [3, 1, 2], [3, 0, 4], [2, 4, 6], [4, 0, 7]]))
