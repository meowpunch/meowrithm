package leetcode

class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
}

class ValidateBinarySearchTree {

    /*
     *       root
     *    left  right
     *
     * preorder
     * root -> left -> right
     */
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBSTWithIteration(root)
//        return isValidBSTWithRecursion(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun isValidBSTWithRecursion(root: TreeNode?, leftBound: Long, rightBound: Long): Boolean {
        // root
        if (root == null) return true
        if (root.`val` <= leftBound || rightBound <= root.`val`) return false

        // left right
        return isValidBSTWithRecursion(root.left, leftBound, root.`val`.toLong())
                && isValidBSTWithRecursion(root.right, root.`val`.toLong(), rightBound)
    }

    private fun isValidBSTWithIteration(root: TreeNode?): Boolean {
        // null check
        if(root == null) return true


        // inorder: left -> root -> right
        // left(prev) < root
        val stack = ArrayDeque<TreeNode>()
        var currNode: TreeNode? = root
        var prevNode: TreeNode? = null

        while (!stack.isEmpty()) {
            // left
            while (currNode != null) {
                stack.addLast(currNode)
                currNode = currNode.left
            }

            // root
            currNode = stack.removeLast()

            if(prevNode != null && prevNode.`val` >= currNode.`val`) return false

            // right
            prevNode = currNode
            currNode = currNode.right
        }

        return true
    }
}

fun main() {

//    print(Solution().isValidBST(null))
}





