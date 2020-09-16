import functools
from collections import Counter
from itertools import combinations


def order_to_combination(order, course):
    combs = dict()
    for length in course:
        combs[length] = []
        temp_combs = combinations(order, length)
        for comb in temp_combs:
            comb = list(comb)
            comb.sort()
            combs[length] += [''.join(comb)]

    # print(combs)
    return combs


def merge(x: dict, y: dict, course):
    merged = dict()
    for length in course:
        merged[length] = x[length] + y[length]

    return merged


def solution(orders, course):
    answer = []

    dicts = list(map(functools.partial(order_to_combination, course=course), orders))
    merged = functools.reduce(functools.partial(merge, course=course), dicts)
    # print(dicts)
    # print(merged)

    for length in course:
        counted = Counter(merged[length])
        # print(counted)
        try:
            most_value = counted.most_common(1)[0][1]
            # print(most_value)
            if most_value < 2:
                continue
        except IndexError:
            continue

        # print(most_value)
        for key in counted:
            if most_value == counted[key]:
                most_value = counted[key]
                answer.append(key)

    answer.sort()
    return answer


if __name__ == '__main__':
    # sol = solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"], [2, 3, 4])
    # print(sol)

    sol = solution(orders=["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], course=[2, 3, 5])
    print(sol)

    sol = solution(["XYZ", "XWY", "WXA"], [2, 3, 4])
    print(sol)
