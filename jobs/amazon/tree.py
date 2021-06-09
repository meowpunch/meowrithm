"""
테스트 케이스 전부 통과
"""
from typing import List


class TreeNode:
    def __init__(self, v=None, c=None):
        if c is None:
            c = []
        self.value = v
        self.children = c


def recursive(root: TreeNode):
    """

    return: 평균, 총 노드 수, 최대 평균, 최대 평균을 가진 노드
    """
    # 리프 컴포넌트인 경우 (노드 수가 하나일땐 최대를 구할떄 안쓰임)
    if not root.children:
        return root.value, 1, None, None

    avg, num, maxAvg, maxNode = root.value, 1, None, None
    for child in root.children:
        a, n, ma, mn = recursive(child)

        avg += a * n
        num += n

        if not maxAvg:
            maxAvg, maxNode = ma, mn
        if ma and maxAvg:
            if ma > maxAvg:
                maxAvg, maxNode = ma, mn

    avg = avg / num
    if not maxAvg or avg > maxAvg:
        return avg, num, avg, root
    else:
        return avg, num, maxAvg, maxNode


if __name__ == '__main__':
    """
    140, 90, 240
                 10 -> 30, 8
         100 -> 35, 4     80 -> 30, 3
     10   20  10       6     4
    
    """

    root = TreeNode(10, [TreeNode(100, [TreeNode(20), TreeNode(10), TreeNode(10)]), TreeNode(80, [TreeNode(6), TreeNode(4)])])
    assert recursive(root)[3].value == 100