from collections import deque


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []

        que = deque()
        que.append((root, 0))
        mem = dict()

        while que:
            n, d = que.popleft()

            mem[d] = mem.get(d, []) + [n.val]

            if n.left:
                que.append((n.left, d + 1))

            if n.right:
                que.append((n.right, d + 1))

        return list(mem.values())