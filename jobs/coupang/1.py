def convert(n, base):
    q, r = divmod(n, base)
    if q == 0:
        return r if r != 0 else 1
    else:
        return convert(q, base) * r if r != 0 else 1


def solution(N):
    producted = list(map(lambda n: [n, convert(N, n)], range(2, 10)))
    print(producted)

    a = sorted(producted, key=lambda x: (x[1], x[0]), reverse=True)
    print(a)
    return producted


if __name__ == '__main__':
    solution(10)
