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
        print("swap {} and {}".format(a.val, b.val))
        temp = a.val
        a.val = b.val
        b.val = temp

    def recursiveInOrderTravel(self, root: TreeNode):
        # left -> root -> right
        # should be increasing sequence
        # 1 2 3 4 5 6
        # 1 6 3 4 5 2 -> change 6, 2
        # 3 2 -> change 3, 2
        # change str of first decreasing and end of second decreasing
        if root.left:
            self.recursiveInOrderTravel(root.left)

        if self.prev:
            if self.prev.val > root.val:
                self.cand += [self.prev, root]

        self.prev = root

        if root.right:
            self.recursiveInOrderTravel(root.right)

    def linearSolution(self, root: TreeNode) -> None:
        # The root of subtree is bigger than leftside and smaller than rightside
        visitedNodes = self.recursiveInOrderTravel(root)
        self.swap(self.cand[0], self.cand[-1])

        # for node in visitedNodes:
        #     print(node.val)

    def morrisInOrderTravel(self, root: TreeNode):

        # initial curr as root
        curr = root

        # iterate while curr is not null
        while curr:
            # if curr have left child
            if curr.left:
                # go rightmost node of curr's left sub tree.
                temp = curr.left
                while temp.right and temp.right != curr:
                    temp = temp.right
                if not temp.right:
                    # assign curr to right null pointer
                    temp.right = curr

                    # go left child of curr
                    curr = curr.left
                else:
                    # detach rightmost node and current
                    temp.right = None

                    if self.prev and self.prev.val > curr.val:
                        self.cand += [self.prev, curr]

                    # visit
                    # print(curr.val)
                    self.prev = curr

                    # go right child
                    curr = curr.right

            # if curr doesn't have left child
            else:
                if self.prev and self.prev.val > curr.val:
                    self.cand += [self.prev, curr]

                # visit
                # print(curr.val)
                self.prev = curr

                # go right child
                curr = curr.right

    def constantSolution(self, root: TreeNode) -> None:
        # The root of subtree is bigger than leftside and smaller than rightside
        visitedNodes = self.morrisInOrderTravel(root)
        self.swap(self.cand[0], self.cand[-1])

    def recoverTree(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """

        # self.linearSolution(root)
        self.constantSolution(root)