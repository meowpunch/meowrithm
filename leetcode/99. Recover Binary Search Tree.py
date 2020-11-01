# Definition for a binary tree node.


# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def __init__(self):
        self.prev = None
        self.cand = []

    @staticmethod
    def swap(a, b):
        temp = a.val
        a.val = b.val
        b.val = temp

    def inorderTravel(self, root: TreeNode):
        # left -> root -> right
        # should be increasing sequence
        # 1 2 3 4 5 6
        # 1 6 3 4 5 2 -> change 6, 2
        # 3 2 -> change 3, 2
        # change str of first decreasing and end of second decreasing
        if root.left:
            self.inorderTravel(root.left)

        if self.prev:
            if self.prev.val > root.val:
                self.cand += [self.prev, root]

        self.prev = root

        if root.right:
            self.inorderTravel(root.right)

    def linearSolution(self, root: TreeNode) -> None:
        # The root of subtree is bigger than leftside and smaller than rightside
        visitedNodes = self.inorderTravel(root)
        self.swap(self.cand[0], self.cand[-1])

        # for node in visitedNodes:
        #     print(node.val)

    def constantSolution(self, root: TreeNode) -> None:
        pass

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        self.linearSolution(root)
