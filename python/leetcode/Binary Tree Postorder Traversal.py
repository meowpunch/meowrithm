# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:


    # left -> right -> root
    # stack = []
    #
    #        1
    #     5     2
    #   4   3 8
    # 7
    #
    # 7 -> 4 -> 3 -> 5 -> 8 -> 2 -> 1
    #
    def postorderTraversal(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []

        stk = [root]
        sol = []
        while stk:
            cur = stk.pop()
            sol.append(cur.val)

            if cur.left:
                stk.append(cur.left)

            if cur.right:
                stk.append(cur.right)

        return sol[::-1]