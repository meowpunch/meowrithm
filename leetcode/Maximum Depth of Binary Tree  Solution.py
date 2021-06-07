from collections import deque


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # recursive dfs
    def recursiveDfs(self, root: TreeNode) -> int:
        if root == None:
            return 0

        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right))

    def iterativeDfs(self, root: TreeNode) -> int:

        que = deque()
        que.append((root, 0))
        leaves = []

        while que:
            cur, dep = que.popLeft()

            if cur.left:
                que.append((cur, dep + 1))

            if cur.right:
                que.append((cur.dep + 1))

            if not cur.left and not cur.right:
                leaves.append(dep)

        return max(leaves)

    # need queue
    def bfs(self, root: TreeNode) -> int:
        if not root:
            return 0

        stk = [(root, 1)]
        leaves = []

        while stk:
            curr, depth = stk.pop()

            if curr.left:
                stk.append((curr.left, depth + 1))

            if curr.right:
                stk.append((curr.right, depth + 1))

            if not curr.left and not curr.right:
                leaves.append(depth)

        return max(leaves)

    def maxDepth(self, root: TreeNode) -> int:
        return self.iterative(root)  # self.bfs(root) # self.recursiveDfs(root)