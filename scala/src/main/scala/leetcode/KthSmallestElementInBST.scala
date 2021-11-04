package leetcode

object KthSmallestElementInBST {
  case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

  def kthSmallest(root: TreeNode, k: Int): Int = {
    def inorder(root: TreeNode): List[Int] = {
      root match {
        case null => List()
        case _ => inorder(root.left) ++ List(root.value) ++ inorder(root.right)
      }
    }

    inorder(root)(k - 1)
  }
}
