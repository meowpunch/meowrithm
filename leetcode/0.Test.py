from collections import deque
from typing import List


def testString(s: str):
    pass

def inplaceArray(arr: List[int]):
    arr[1] = 2


def sortArray(arr: List[int]):
    arr.sort()


def reverseArray(arr: List[int]):
    return reversed(arr)


def initArray():
    a = [0] * 3

    # copied address
    b = [[0] * 3] * 3
    c = [[0] * 3 for _ in range(3)]

    a[0] = 1
    b[0][0] = 1
    c[0][0] = 1

    print(a, b, c)


def testArray():
    arr = list(range(5))

    inplaceArray(arr)

    print(arr)


def testDict():
    d = dict()

    d.get(1, -1)


def a(l: List[int]) -> List[tuple]:
    return []


def removeProduct(num, ids, rem):
    mem = dict()

    for id in ids:
        mem[id] = mem.get(id, 0) + 1

    print(mem)
    # sort by value
    sortedMem = sorted(mem.items(), key=lambda x: x[1], reverse=True)

    print(sortedMem)
    for k, v in sortedMem:
        if rem - v < 0:
            break
        else:
            rem = rem - v
            sortedMem[k] = 0

    return len(list(map(lambda t: t[0], filter(lambda x: x[1] > 0, sortedMem))))

if __name__ == '__main__':

    removeProduct(5, [1,2,2,3,3], 3)
    # testArray()
    # initArray()

    # print("asd:  / 123sDd".is)
    i = 2**33

    m = {1:2, 3:4, 5:3, -1:3}
    s = sorted(m.items(), key = lambda x: x[1])

    for k, v in s:
        print(k, v)
    # def func(x):
    #     print(x)
    #     return True
    #
    # print(list(filter(func,  m)))


    # for a in m.items():
    #     print(a)

    # a = [1,2,3]
    # a.pop()
    # a.append([2, 3])
    # print(a)x
    #
    # print(a+[1,3])
    #
    # print(a.pop(0))
    # print(a)
    #
    # q = deque()
    #
    # dict().val
