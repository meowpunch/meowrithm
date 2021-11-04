package leetcode

import data.TreeNode

object BalanceBST {


  def main(args: Array[String]): Unit = {
    /*
             5
          3     6
        2   4     7
      1
    */
    val n = TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4)), TreeNode(6, null, TreeNode(7)))
    assert(inorder(n) == List(1, 2, 3, 4, 5, 6, 7))
  }

  def balanceBST(root: TreeNode): TreeNode = buildBST(inorder(root))


  /*
      1. mid of list is root node
      2. leftList is left subTree, rightList is right subTree

      odd nums
      List(1, 2, 3) -> List(1) List(2, 3)
      even nums
      List(1, 2, 3, 4) -> List(1, 2) List(3, 4)
  */
  def buildBST(ns: List[Int]): TreeNode = {
    ns match {
      case Nil => null
      case _ => ns.splitAt(ns.size / 2) match {
        case (l, m :: r) => TreeNode(m, buildBST(l), buildBST(r))
        case _ => throw new UnsupportedOperationException()
      }
    }
  }

  /*
      reverse inorder traversal ( right -> root -> left )
      because prepend element to list not append
   */
  def inorder(n: TreeNode): List[Int] = {
    @annotation.tailrec
    def inorder(stk: List[TreeNode], acc: List[Int]): List[Int] =
      stk match {
        case Nil => acc
        case h :: t =>
          h match {
            // go right
            case TreeNode(_, _, r) if r != null => inorder(r :: TreeNode(h.value, h.left, null) :: t, acc)
            // add value
            case TreeNode(v, null, null) => inorder(t, v :: acc)
            // add value and go left
            case TreeNode(v, l, null) => inorder(l :: t, v :: acc)
          }
      }

    inorder(List(n), List())
    /*
      if (n == null) List()
      else inorder(n.left) ::: n.value :: inorder(n.right)
    */
  }

}
