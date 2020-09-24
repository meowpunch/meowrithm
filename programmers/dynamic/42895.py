# 12 = 5 + 5 + (5 / 5) + (5 / 5)
# 12 = 55 / 5 + 5 / 5
# 12 = (55 + 5) / 5

# f(n) n번 사용해서 만들 수 있는 모든 조합
# f(3)은 f(1), f(2)를 합친다(사칙연산).

# 테스트 케이스 2,9 통과 못


def solution(N, number):
    # n번 사용해서 만들 수 있는 조합들 n : combs
    combs_set = dict()

    # initialize
    combs_set[0] = {}
    combs_set[1] = {N}
    if N == number:
        return 1
    n = 2

    while n <= 8:

        # 사칙연산 아닌거
        n_combs = {sum(10 ** idx for idx in range(n)) * N}

        for i in range(1, n // 2 + 1):
            # print(i, n-i)
            a_combs = combs_set[i]
            b_combs = combs_set[n - i]

            # print(a_combs, b_combs)
            for a_comb in a_combs:
                for b_comb in b_combs:
                    # 사칙연산
                    for ele in [a_comb + b_comb, a_comb - b_comb, b_comb - a_comb, a_comb * b_comb]:
                        n_combs.add(ele)

                    if b_comb != 0:
                        n_combs.add(a_comb // b_comb)

                    if a_comb != 0:
                        n_combs.add(b_comb // a_comb)

        if number in n_combs:
            return n

        combs_set[n] = set(n_combs)
        n += 1

    return -1


if __name__ == '__main__':
    print(solution(5, 22))
    print(solution(5, 3600))
    print(solution(4, 17))
