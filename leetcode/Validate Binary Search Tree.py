# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    #        a
    #     b     c
    #   d   e
    #
    # inorder search (Left -> Root -> Right)    : d -> b -> e -> a -> c
    # preorder search (Root -> Left -> Right)   : a -> b -> d -> e -> c
    # postorder search (Left -> Right -> Root)  : d -> e -> b -> c -> a
    #
    # Binary Search Tree's condition: Left < Root < Right
    #
    # Let's use inorder search.
    # every element in inorder traversal is smaller than the next one.

    prev = -math.inf

    # return minimum value of tree
    def inorderSearch(self, root: TreeNode) -> bool:
        if not root:
            return True

        if not self.inorderSearch(root.left):
            return False

        if root.val <= self.prev:
            return False

        self.prev = root.val

        return self.inorderSearch(root.right)

    def boundedLimit(self, root: TreeNode, low=-math.inf, high=math.inf):
        if not root:
            return True

        if not (low < root.val < high):
            return False

        return self.boundedLimit(root.left, low, root.val) and self.boundedLimit(root.right, root.val, high)

    def isValidBST(self, root: TreeNode) -> bool:
        return self.boundedLimit(root)  # self.inorderSearch(root)

