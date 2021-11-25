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


"""
    1
   2
  3
 4 

Wrong Answer: 4 - 3 - 4 - 2 - 4 - 3 - 4 - 1

def iterating(root):
    res = []

    # using stack
    stack = [root]
    # cur not represent isTraveled
    cur = root

    while stack:
        while cur.left:
            stack.append(cur.left)
            cur = cur.left

        cur = stack.pop()
        res.append(cur.val)
        # cur = cur.right
        if cur.right:
            # print("right", cur.right.val)
            stack.append(cur.right)
            cur = cur.right

    return res
"""


def threaded(root: TreeNode):
    """
        A binary tree is threaded by making all right child pointers that would normally be null point to the in-order successor of the node
        (if it exists), and all left child pointers that would normally be null point to the in-order predecessor of the node.

        Treaded Binary Tree - Morris Traversal

        1. Initialize current as root

        2. While current is not NULL
           If the current does not have left child
              a) Print current’s data
              b) Go to the right, i.e., current = current->right
           Else
              a) Make current as the right child of the rightmost
                 node in current's left subtree
              b) Go to this left child, i.e., current = current->left
    """
    res = []

    # Initialize current as root
    curr = root

    while curr:
        if not curr.left:
            # print(curr.val)
            res.append(curr.val)
            curr = curr.right
        else:
            # a) Make current as the right child of the rightmost node in current's left subtree
            # -> right child pointers would normally be null point to the in-order successor of the node
            temp = curr.left
            while temp.right:
                temp = temp.right

            temp.right = curr

            # b) Go to this left child, i.e., current = current->left
            left = curr.left
            curr.left = None
            curr = left

    return res


class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        """
            Left -> Root -> Right

        """
        if not root:
            return []

        return threaded(root)
        # return iterating(root)
        # return recursive(root)