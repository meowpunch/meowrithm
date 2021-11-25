import heapq


def solution(n, edges):
    connected = dict()
    for e in edges:
        try:
            connected[e[0]] += [e[1]]
        except KeyError:
            connected[e[0]] = [e[1]]

    children_info = [0] * n

    def search_children(node):
        try:
            count = 0
            for c_n in connected[node]:
                count += search_children(c_n)

            children_info[node] = count
            return count + 1

        except KeyError:
            children_info[node] = 0
            return 1

    search_children(0)

    print(connected)

    q = [(children_info[0], 0)]
    count = 0

    # 다 방문 (1 depth)
    # 다 방문하면서 연결된 애들 추가
    # 자식 최대 제외 후
    while len(q) > 0:
        new_q = []
        while len(q) > 0:
            # 방문
            _, node = q[0]
            q = q[1:] if len(q) > 0 else []

            # 추가
            try:
                for c_n in connected[node]:
                    new_q.append((children_info[c_n], c_n))
            except KeyError:
                continue

        q = new_q
        # 가장 큰거 제외
        if len(q) > 0:
            q.remove(max(q, key=lambda x: x[0]))
        else:
            break

    return count


if __name__ == '__main__':
    solution(n=19,
             edges=[[0, 1], [0, 2], [0, 3], [1, 4], [1, 5], [2, 6], [3, 7], [3, 8], [3, 9], [4, 10], [4, 11], [5, 12],
                    [5, 13], [6, 14], [6, 15], [6, 16], [8, 17], [8, 18]])
