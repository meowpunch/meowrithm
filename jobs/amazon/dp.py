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
