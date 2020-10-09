def solution(m, k):
    answer = []

    for c in m:
        print(answer, k)
        try:
            idx = k.index(c)
            k = k[:idx] + k[idx + 1:]
        except ValueError:
            answer.append(c)
            continue

    # std = 0
    # while len(k) > 0:
    #
    #     c = m[std]
    #     try:
    #         idx = k.index(c)
    #         k = k[:idx] + k[idx+1:]
    #         std += 1
    #     except ValueError:
    #         answer.append(c)
    #         std += 1
    #         continue

    return ''.join(answer)


if __name__ == '__main__':
    print(solution(m="kkaxbycyz", k="abc"))
    print(solution(	"acbbcdc", "abc"))
