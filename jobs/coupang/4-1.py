from collections import defaultdict, deque


def solution(depar, hub, dest, roads):
    connected = defaultdict(list)
    for road in roads:
        connected[road[1]].append(road[0])

    mem = defaultdict(int)
    mem[depar] += 1

    def calculate(x, source):
        if x == source:
            return mem[x]

        res = 0
        for c_n in connected[x]:
            if mem[c_n]:
                res += mem[c_n]
            else:
                res += calculate(c_n, source)

        mem[x] = res
        return res

    tmp = calculate(hub, depar)
    mem = defaultdict(int)
    mem[hub] = tmp
    return calculate(dest, hub)

if __name__ == '__main__':
    sol = solution("SEOUL", "DAEGU", "YEOSU", [
        ["ULSAN", "BUSAN"], ["DAEJEON", "ULSAN"], ["DAEJEON", "GWANGJU"], ["SEOUL", "DAEJEON"], ["SEOUL", "ULSAN"], [
            "DAEJEON", "DAEGU"], ["GWANGJU", "BUSAN"], ["DAEGU", "GWANGJU"], ["DAEGU", "BUSAN"], ["ULSAN", "DAEGU"], [
            "GWANGJU", "YEOSU"], ["BUSAN", "YEOSU"]])
    print(sol)

    sol = solution("ULSAN",    "SEOUL",    "BUSAN",[
        ["SEOUL", "DAEJEON"], ["ULSAN", "BUSAN"], ["DAEJEON", "ULSAN"], ["DAEJEON", "GWANGJU"], ["SEOUL", "ULSAN"], [
            "DAEJEON", "BUSAN"], ["GWANGJU", "BUSAN"]])

    print(sol)
