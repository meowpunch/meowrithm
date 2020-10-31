# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

def recursive(root: TreeNode):
    left = recursive(root.left) if root.left else []
    right = recursive(root.right) if root.right else []

    return left + [root.val] + right


def iterating(root):
    res = []

    # using stack
    stack = []
    # cur not represent isTraveled
    cur = root

    while cur or stack:
        while cur:
            # print(cur.left.val)
            stack.append(cur)
            cur = cur.left

        cur = stack.pop()
        res.append(cur.val)
        cur = cur.right
        # if cur.right:
        #     print("right", cur.right.val)
        #     stack.append(cur.right)
        #     cur = cur.right

    return res


def threaded():
    # Treaded Binary Tree - Morris Traversal
    pass


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        """
            Left -> Root -> Right

        """
        if not root:
            return []

        return iterating(root)
        # return recursive(root)