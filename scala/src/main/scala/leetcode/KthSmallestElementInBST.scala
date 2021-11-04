package leetcode

import data.TreeNode

object KthSmallestElementInBST {
  def main(args: Array[String]): Unit = {
    /*
               5
            3     6
          2   4     7
        1
    */
    val n = TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4)), TreeNode(6, null, TreeNode(7)))
    assert(kthSmallest(n, 4) == 4)
  }

  def kthSmallest(root: TreeNode, k: Int): Int = {
    /*
        stk is todo list to visit
     */
    @annotation.tailrec
    def inorder(stk: List[TreeNode], k: Int): Int =
      stk match {
        case Nil => throw new IllegalArgumentException()
        case h :: t => (h, k) match {
          case (TreeNode(v, _, _), 1) => print(v); v
          // go left
          case (TreeNode(_, l, _), _) if l != null => inorder(l :: TreeNode(h.value, null, h.right) :: t, k)
          // visit
          case (TreeNode(v, null, null), _) => inorder(t, k - 1)
          // visit and go right
          case (TreeNode(v, null, r), _) => inorder(r :: t, k - 1)
        }
      }

    inorder(List(root), k)

    /*
        def inorder(root: TreeNode): List[Int] = {
          root match {
            case null => List()
            case _ => inorder(root.left) ++ List(root.value) ++ inorder(root.right)
          }
        }
     */
  }
}
