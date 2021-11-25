# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from collections import deque


class Solution:

    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        # (ie, from left to right, then right to left for the next level and alternate between).
        # ->  BFS
        # queue for BFS and stack for Zigzag

        # mem = dict()
        ans = []

        # queue
        q = deque()
        # lvl and val
        if not root:
            return []

        q.append((0, root))

        while len(q) > 0:
            stack = []
            tempA = []
            while len(q) > 0:
                lvl, cur = q.popleft()
                tempA.append(cur.val)
                stack.append(cur)

            ans.append(tempA)

            while len(stack) > 0:
                node = stack.pop()

                nextLvl = lvl + 1

                if nextLvl % 2 == 0:
                    # left -> right
                    if node.left:
                        q.append((nextLvl, node.left))
                    if node.right:
                        q.append((nextLvl, node.right))
                else:
                    # right -> left
                    if node.right:
                        q.append((nextLvl, node.right))
                    if node.left:
                        q.append((nextLvl, node.left))

        return ans