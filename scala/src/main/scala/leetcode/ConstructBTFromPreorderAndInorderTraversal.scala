package leetcode

import data.TreeNode

object ConstructBTFromPreorderAndInorderTraversal {

  /*
                5
            3       6
          2  4    7   8
        1

        inorder : 1 2 3 4 5 7 6 8
        preorder: 5 3 2 1 4 6 7 8

        1. let head of preorder be root
          root: 5
        2. split inorder
          left sub tree: i: 1 2 3 4, p: 3 2 1 4
          right subtree: i: 7 6 8  , p: 6 7 8

          1
         2
        3
       4 6
      5

        inorder : 5 4 3 6 2 1
        preorder: 1 2 3 4 5 6


        - terminology
        p: preorder, pl: left sub tree, pr: right
        r: root
   */
  def buildTree(preorder: Array[Int], inorder: Array[Int]): TreeNode = {
    def build(p: List[Int], i: List[Int]): TreeNode = {
      p match {
        // base case
        case Nil => null
        case r :: pt => i.span(_ != r) match {
          case (il, _ :: ir) =>
            val (pl, pr) = pt.splitAt(il.size)
            TreeNode(r, build(pl, il), build(pr, ir))
          case _ => throw new IllegalArgumentException();
        }
      }
    }

    build(preorder.toList, inorder.toList)
  }

}
