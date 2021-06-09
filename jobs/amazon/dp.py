"""
rem 만큼 ids 의 원소를 지울 수 있을때, ids 의 최소 distinct 숫자들 수
테스트케이스 8개 중 2개 통과
"""
def removeProduct(num, ids, rem):
    mem = dict()

    for i in ids:
        mem[i] = mem.get(i, 0) + 1

    # sort by value
    sortedMem = sorted(mem.items(), key=lambda x: x[1], reverse=True)

    while rem > 0:
        k, v = sortedMem.pop()

        if rem - v < 0:
            sortedMem.append((k, v))
            break
        else:
            rem = rem - v

    return len(sortedMem)


if __name__ == '__main__':
    assert removeProduct(5, [1, 2, 2, 1, 3], 2) == 2

    assert removeProduct(2, [1, 1], 2) == 0

    assert removeProduct(2, [1, 1], 2) == 0
