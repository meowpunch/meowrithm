"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""


class Solution:
    def __init__(self):
        self.max_depth = 0

    def traverse(self, root: 'Node', depth: int) -> None:
        if not root:
            return

        self.max_depth = max(depth, self.max_depth)

        for child in root.children:
            self.traverse(child, depth + 1)

    def maxDepth(self, root: 'Node') -> int:
        self.traverse(root, 1)
        return self.max_depth



