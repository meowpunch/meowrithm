from collections import deque

if __name__ == '__main__':
    a = [1,2,3]

    a.append([2, 3])
    print(a)

    print(a+[1,3])

    print(a.pop(0))
    print(a)

    q = deque()

    dict().val