def search(current, networks, visited, count):
    visited[current] = 1

    for idx, isConnected in enumerate(networks[current]):
        # 연결돼있고 방문안했으면 감
        if isConnected and not visited[idx]:
            search(idx, networks, visited, count)


def solution(n, computers):
    visited = [0] * n
    count = 0
    for i in range(n):
        if not visited[i]:
            search(current=i, networks=computers, visited=visited, count=0)
            count += 1

    return count


if __name__ == '__main__':
    print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
    print(solution(3, [[1, 1, 0], [1, 1, 1], [0, 1, 1]]))
