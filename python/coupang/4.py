from collections import defaultdict, deque


def solution(depar, hub, dest, roads):
    connected = defaultdict(list)
    for road in roads:
        connected[road[0]].append(road[1])

    mem = defaultdict(int)
    mem[depar] += 1

    # BFS
    queue = deque()
    queue.append(depar)
    visited = defaultdict(int)

    while len(queue) > 0:
        current_node = queue.popleft()
        visited[current_node] = 1

        for connected_node in connected[current_node]:
            mem[connected_node] += mem[current_node]

            if not visited[connected_node] and connected_node not in queue:
                queue.append(connected_node)


    print(mem)
    return mem[dest]


if __name__ == '__main__':
    sol = solution("SEOUL", "DAEGU", "YEOSU", [
        ["ULSAN", "BUSAN"], ["DAEJEON", "ULSAN"], ["DAEJEON", "GWANGJU"], ["SEOUL", "DAEJEON"], ["SEOUL", "ULSAN"], [
            "DAEJEON", "DAEGU"], ["GWANGJU", "BUSAN"], ["DAEGU", "GWANGJU"], ["DAEGU", "BUSAN"], ["ULSAN", "DAEGU"], [
            "GWANGJU", "YEOSU"], ["BUSAN", "YEOSU"]])
    print(sol)
