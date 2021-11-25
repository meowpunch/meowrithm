from itertools import combinations


def distance(comb: tuple):
    delta_x = comb[0][0] - comb[1][0]
    delta_y = comb[0][1] - comb[1][1]
    return (delta_x ** 2 + delta_y ** 2) ** 1 / 2


def center(comb: tuple):
    x = (comb[0][0] + comb[1][0]) / 2
    y = (comb[0][1] + comb[1][1]) / 2
    return x, y


def solution(v):
    answer = []
    combs = combinations(v, 2)

    longest_comb = None
    longest_value = 0
    for comb in combs:
        if distance(comb) > longest_value:
            longest_value = distance(comb)
            longest_comb = comb
        # print(comb)

    center_point = center(longest_comb)
    print(center_point)
    filtered = filter(lambda p: p not in longest_comb, v)
    remain_point = next(filtered)
    print(remain_point)

    answer.append(int(2 * center_point[0] - remain_point[0]))
    answer.append(int(2 * center_point[1] - remain_point[1]))

    return answer


if __name__ == '__main__':
    sol = solution(v=[[1, 4], [3, 4], [3, 10]])
    print(sol)
