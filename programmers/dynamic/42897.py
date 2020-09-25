# 일직선이라고 일단 가정하고 생각해보자
# 조건이 있는 최대합 문제
# ... i-4 i-3 i-2 i-1 i
# f(i)는 i를 포함하는 최대
# f(i) <- max(f(i-2), f(i-3)) + money(i)

# num = len(money)라고 하고 원이라고 가정하면
# f(num)은 money(0)을 먹을 수 없음
# 0을 포함한 것을 기억해야함 -> 이게 아니고 0에서 시작한 것과 1에서 시작한걸 나눠서 가야함
# 이때의 최대값을 따로 기억해야한다.

# f(i, 1), f(i, 0) 따로
# f(i, 1)은 1을 포함해서 시작해서 i에서 끝나는 최대값


def solution(money):
    # 초기화
    num = len(money)

    # num == 1인 경우
    if num == 1:
        return money[0]

    # num == 2인 경우
    if num == 2:
        return max(money[0], money[1])

    # num == 3
    if num == 3:
        return max(money[0] + money[2], money[1])

    # num >= 4
    f_1 = [0 for _ in range(num)]
    f_0 = [0 for _ in range(num)]

    f_0[0] = money[0]
    f_0[1] = 0

    f_1[0] = 0
    f_1[1] = money[1]

    f_0[2] = f_0[0] + money[2]
    f_1[2] = money[2]

    # num >= 3, idx > 2
    for idx in range(3, num - 1):
        f_0[idx] = max(f_0[idx - 2], f_0[idx - 3]) + money[idx]
        f_1[idx] = max(f_1[idx - 2], f_1[idx - 3]) + money[idx]

    # idx = num-1 마지막 경우
    f_0[num - 1] = 0
    f_1[num - 1] = max(f_1[num - 3], f_1[num - 4]) + money[num - 1]

    return max(max(f_0), max(f_1))


if __name__ == '__main__':
    solution([1, 2, 3, 1, 5, 10, 2])
