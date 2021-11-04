package leetcode

import data.TreeNode
import leetcode.SerializeDeserializeBT.{NULL, SPLITTER}

import scala.collection.immutable.Queue

class SerializeDeserializeBT {

  /*
    Encodes a list of strings to a single string.

    preorder with que
  */
  def serialize(root: TreeNode): String = {
    def preorder(n: TreeNode): List[String] = {
      n match {
        case null => List(NULL)
        case n => n.value.toString :: preorder(n.left) ::: preorder(n.right)
      }
    }

    preorder(root).mkString(SPLITTER)
  }

  def bfs(root: TreeNode): String = {
    @annotation.tailrec
    def loop(que: Queue[TreeNode], acc: List[String]): List[String] =
      que.dequeue match {
        // base case
        case (null, rq) if rq.isEmpty => NULL :: acc
        case (null, rq) => loop(rq, NULL :: acc)
        case (h, rq) => loop(rq.enqueue(h.left).enqueue(h.right), h.value.toString :: acc)
      }

    loop(Queue(root), List()).reverse.mkString(SPLITTER)
  }

  /*
      Decodes a single string to a list of strings.

                5
            3       6
          2  4        7
        1

      preorder: 5 3 2 1 N N N 4 N N 6 N 7 N N

       1. choose root val - 5
       2. construct leftSubTree
       3. construct rightSubTree
   */
  def deserialize(data: String): TreeNode = {
    def buildTree(xs: List[String]): (TreeNode, List[String]) = {
      xs match {
        case Nil => (null, List())
        case NULL :: rest => (null, rest)
        case root :: rest =>
          val (left, lr) = buildTree(rest)
          val (right, rr) = buildTree(lr)

          TreeNode(root.toInt, left, right) -> rr
      }
    }

    buildTree(data.split(SPLITTER).toList)._1
  }


}

object SerializeDeserializeBT {
  val SPLITTER = " "
  val NULL = "N"

  def main(args: Array[String]): Unit = {
    /*
                5
            3       6
          2  4        7
        1

      preorder: 5 3 2 1 N N N 4 N N 6 N 7 N N

     */
    val sd = new SerializeDeserializeBT()
    val s = sd.serialize(
      TreeNode(5, TreeNode(3, TreeNode(2, TreeNode(1)), TreeNode(4)), TreeNode(6, null, TreeNode(7)))
    )
    println(s)
    println(sd.serialize(sd.deserialize(s)))
  }
}
