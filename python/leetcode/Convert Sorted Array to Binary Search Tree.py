# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def divide(self, nodes: List[int]):
        n = len(nodes)
        return nodes[n // 2], nodes[0: n // 2], nodes[n // 2 + 1: n]

    def makeTree(self, root: int, leftSub: List[int], rightSub: List[int]) -> TreeNode:
        rootNode = TreeNode(root)

        if not leftSub and not rightSub:
            return rootNode

        if leftSub:
            root, left, right = self.divide(leftSub)
            # print(root, left, right)
            rootNode.left = self.makeTree(root, left, right)

        if rightSub:
            root, left, right = self.divide(rightSub)
            # print(root, left, right)
            rootNode.right = self.makeTree(root, left, right)

        return rootNode

    def sortedArrayToBST(self, nums: List[int]) -> TreeNode:
        root, left, right = self.divide(nums)
        # print(root, left, right)
        return self.makeTree(root, left, right)
