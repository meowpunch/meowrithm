# Definition for a binary tree node.
from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0

        # min depth를 찾기위해서는 역시 BFS 너비우선탐색이지!
        q = deque([(root, 1)])

        while q:
            node, depth = q.popleft()

            children = [node.left, node.right]
            filtered_children = list(filter(lambda x: x, children))

            if len(filtered_children) == 0:
                return depth
            else:
                for n in filtered_children:
                    q.append((n, depth + 1))
