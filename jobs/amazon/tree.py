"""

"""
from typing import List


class TreeNode:
    value = None
    children = []


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

        if not maxAvg:
            maxAvg, maxNode = ma, mn
        if not