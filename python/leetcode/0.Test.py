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


if __name__ == '__main__':

    # testArray()
    # initArray()

    s = ""
    if not s:
        print("empty")

    set().a
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
