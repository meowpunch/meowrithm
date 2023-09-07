# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:


    # it doesn't work without assumption, ``All nodes[i] are distinct.``
    def lowestCommonAncestor(self, root: 'TreeNode', nodes: 'List[TreeNode]') -> 'TreeNode':
        nodes_set = set(nodes)

        def traverse(root: 'TreeNode') -> 'TreeNode':

            if not root:
                return None

            left = traverse(root.left)
            right = traverse(root.right)

            if left and right:
                return root

            if root in nodes_set:
                return root

            return left or right

        return traverse(root)


    #
    #   left -> right -> root
    #
    def lowestCommonAncestorOne(self, root: 'TreeNode', nodes: 'List[TreeNode]') -> 'TreeNode':
        nodes_set = set(nodes)

        self.found = None
        def traverse(root: 'TreeNode') -> int:

            if not root:
                return 0

            number_of_ancestors = traverse(root.left) + traverse(root.right)

            if root in nodes_set:
                number_of_ancestors += 1

            if len(nodes_set) == number_of_ancestors:
                self.found = self.found or root

            return number_of_ancestors

        traverse(root)
        return self.found
