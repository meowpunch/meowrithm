from functools import reduce


def solution(blocks):

    result = []
    depth = len(blocks)

    # 한층씩 채움
    for d in range(depth):
        if d == 0:
            result.append([blocks[d][1]])
            continue

        # 채워진 기준 블럭의 인덱스와 값
        std_idx, std_val = blocks[d][0], blocks[d][1]

        # 초기화
        empty = -100000000
        temp = [empty] * (d + 1)
        temp[std_idx] = std_val

        left, right = std_idx - 1, std_idx + 1
        # 왼쪽채우기
        while left >= 0:
            temp[left] = result[d - 1][left] - temp[left + 1]
            left -= 1
        # 오른쪽 채우기
        while right <= d:
            temp[right] = result[d - 1][right - 1] - temp[right - 1]
            right += 1

        # 다채우면 넣어줌
        result.append(temp)

    # 펼쳐줌줌
    return list(reduce(lambda l, r: l + r, result))


# pyramid = [[blocs[d][1] if blocks[d][0] == i else 0 for i in range(d+1)] for d in range(depth)]
#     print(pyramid)


if __name__ == '__main__':
    print(solution([[0, 50], [0, 22], [2, 10], [1, 4], [4, -13]]))
