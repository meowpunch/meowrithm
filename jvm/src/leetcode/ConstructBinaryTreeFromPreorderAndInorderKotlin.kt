package leetcode

import data.TreeNode

class ConstructBinaryTreeFromPreorderAndInorderKotlin {

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        /*
                        3
                    9       20
                      7    8  13
                     1 2        5

            inorder: left -> root -> right  e.g. [9, 1, 7, 2, 3, 8, 20, 13, 5]
            preorder: root -> left -> right e.g. [3, 9, 20, 7, 8, 13, 1, 2, 5]


            root: preorder[0] => 3
            leftSubTree: [9, 1, 7, 2] rightSubTree: [8, 20, 13, 5]
            root 9                    root 20
            LST [] RST[1, 7, 2]       LST [8] RST [13, 5]
        */

    }
}