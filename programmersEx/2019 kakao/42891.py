# 무지의 먹방 라이브
def rotate_foods(foods, rotate_num):
    rotated = []
    for food in foods:
        if food[1] > rotate_num:
            new_food = (food[0], food[1] - rotate_num)
            rotated.append(new_food)
    return rotated


# 총 몇바퀴 돌까?
# 한바퀴돌면 어차피 남은 애들 중 원점
# 최소 몇바퀴? min_rotate K / food_times 길이 만큼은 적어도 돌 수 있음.
# min_rotate 만큼 돌면

def solution(food_times, k):
    foods = [(idx, time) for idx, time in enumerate(food_times, 1)]
    size = len(foods)
    # k < food_items 일때 terminate
    while k >= size:
        if size == 0:
            return -1
        rotate_num = int(k / size)
        rotated = []

        for food in foods:
            if food[1] > rotate_num:
                new_food = (food[0], food[1] - rotate_num)
                rotated.append(new_food)
                k -= rotate_num
            else:
                size -= 1
                k -= food[1]

        foods = rotated

    answer = foods[k][0]
    return answer


if __name__ == '__main__':
    sol = solution([3, 1, 2], 5)
    print(sol)
