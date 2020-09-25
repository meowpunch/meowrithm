from collections import deque


# 차량은 routes의 인덱스

def solution(routes):
    # 끝 지점로 오름차순 정렬
    sorted_cars = deque(sorted(routes, key=lambda x: x[1]))

    answer = 0
    # 차량 모두 해결하면 끝
    while len(sorted_cars) > 0:
        # 기준(첫) 차량의 끝이 시작지점과 걸리는 차량 지움
        std_str, std_end = sorted_cars.popleft()
        answer += 1

        temp = []
        for car in sorted_cars:
            str, end = car

            if str <= std_end:
                temp.append(car)

        for car in temp:
            sorted_cars.remove(car)

    return answer


if __name__ == '__main__':
    print(solution([[-20, -15]]))
    print(solution([[0,5],[1,2],[3,4],[4,6]]))
