# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def inorderTravel(self, root: TreeNode):
        leftSubTree = self.inorderTravel(root.left) if root.left else []
        rightSubTree = self.inorderTravel(root.right) if root.right else []

        filteredLeft = next(filter(lambda node: node.val > root.val, leftSubTree))

        if filteredLeft:
            temp = filteredLeft
            filteredLeft = root
            root = temp

        filteredRight = next(filter(lambda node: node.val > root.val, rightSubTree))

        if filteredRight:
            temp = filteredRight
            filteredRight = root
            root = temp

        return leftSubTree + rightSubTree + [root]

    def linearSolution(self, root: TreeNode) -> None:
        # The root of subtree is bigger than leftside and smaller than rightside

        visitedNodes = self.inorderTravel(root)

        for node in visitedNodes:
            print(node.val)

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        self.linearSolution(root)
