package leetcode

import data.TreeNode

object KthSmallestElementInBSTScala {
  def kthSmallest(root: TreeNode, k: Int): Int = {
    def inorder(root: TreeNode): List[Int] = {
      root match {
        case null => List()
        case _ => inorder(root.getLeft) ++ List(root.getVal) ++ inorder(root.getRight)
      }
    }

    inorder(root)(k - 1)
  }
}
