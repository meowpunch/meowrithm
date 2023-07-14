package leetcode.kotlin

import data.TreeNode

fun main() {
    println(
        ConstructBinaryTreeFromPreorderAndInorderKotlin().buildTree(
            listOf(3, 9, 20, 15, 7).toIntArray(),
            listOf(9, 3, 15, 20, 7).toIntArray()
        )
    )
}

class ConstructBinaryTreeFromPreorderAndInorderKotlin {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        /*
                        3
                    9       20
                      7    8  13
                     1 2        5

            inorder: left -> root -> right  e.g. [9, 1, 7, 2, 3, 8, 20, 13, 5]
            preorder: root -> left -> right e.g. [3, 9, 7, 1, 2, 20, 8, 13, 5]


            root: preorder[0] => 3
            leftSubTree: [9, 1, 7, 2] rightSubTree: [8, 20, 13, 5]
            root 9                    root 20
            LST [] RST[1, 7, 2]       LST [8] RST [13, 5]
        */
        //
//        val inorderIndexToValue = inorder.mapIndexed { index, value -> value to index }.toMap()

        fun build(preorder: IntArray, inorder: IntArray): TreeNode? {
            if (preorder.isEmpty()) return null
            else {
                val rootVal = preorder[0]
                val rootNode = TreeNode(rootVal)
                val inorderRootIdx = inorder.indexOf(rootVal)

                rootNode.left =
                    build(preorder.copyOfRange(1, inorderRootIdx + 1), inorder.copyOfRange(0, inorderRootIdx))
                rootNode.right = build(
                    preorder.copyOfRange(inorderRootIdx + 1, preorder.size),
                    inorder.copyOfRange(inorderRootIdx + 1, inorder.size)
                )
                return rootNode
            }
        }

        return build(preorder, inorder)
    }

}
