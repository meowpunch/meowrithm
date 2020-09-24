def search(summation, nodes, target):
    # 비었고 타겟 값이라면 1 아니면 0
    if len(nodes) == 0:
        if summation == target:
            return 1
        else:
            return 0

    ele = nodes[0]
    return search(summation + ele, nodes[1:], target) + search(summation - ele, nodes[1:], target)


def solution(numbers, target):
    return search(summation=0, nodes=numbers, target=target)


if __name__ == '__main__':
    print(solution([1, 1, 1, 1, 1], 3))

    # print(solution([1,5,2,3,90,43,22,1,5,32], ))
