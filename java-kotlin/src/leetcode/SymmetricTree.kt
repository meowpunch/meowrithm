package leetcode

import data.TreeNode

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isMirror(root, root)
    }

    private fun isMirror(leftSub: TreeNode?, rightSub: TreeNode?): Boolean {
        return if (leftSub == null && rightSub == null) true
        else if (leftSub == null || rightSub == null) false
        else (leftSub.`val` == rightSub.`val`) && isMirror(leftSub.left, rightSub.right) && isMirror(leftSub.right, rightSub.left)
    }
}