# 입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때,
# 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.

# 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다.
# 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 이상 1,000,000,000분 이하입니다.
# 심사관은 1명 이상 100,000명 이하입니다.

# 사람 수 n, 심사관 수 m


def predict(works, times):
    acc_works = [w + t for w, t in zip(works, times)]
    return acc_works.index(min(acc_works))


def solution2(n, times):
    # times 를 오름차순 정렬한다. m log m
    # [7, 10, 22 ,50]
    m = len(times)
    works = [0] * m

    # 입국 심사 명수 만큼 돌면서, 적절하게 배치한다. n log m
    passed_num = 0
    while passed_num < n:
        idx = predict(times, works)
        works[idx] += times[idx]
        passed_num += 1
        # 추가돼서 가장 짧은 곳으로 간다.
    # print(works)
    return max(works)


def search(left, right, n, times):
    # base
    if left >= right:
        return left

    mid = (left + right) // 2
    passed = 0

    for time in times:
        passed += mid // time
        if passed >= n:
            break

    if passed >= n:
        return search(left, mid, n, times)
    else:
        return search(mid + 1, right, n, times)


def solution(n, times):
    # 정답인 시간을 기준으로 이분 탐색하자
    # 0 ~ n * max(times) 사이를 탐색한다.

    return search(0, n * max(times), n, times)


if __name__ == '__main__':
    print(solution(n=6, times=[7, 10]))

    print(solution(n=10, times=[7, 50, 22, 10]))
