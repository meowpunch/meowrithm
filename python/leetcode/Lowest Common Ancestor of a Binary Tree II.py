# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        nodes_set = {p, q}

        def traverse(root: 'TreeNode'):

            if not root:
                return None

            left = traverse(root.left)
            right = traverse(root.right)

            if left and right:
                return root

            if root in nodes_set:
                nodes_set.remove(root)
                return root

            return left or right

        result = traverse(root)

        if not nodes_set:
            return result
        else:
            return None


