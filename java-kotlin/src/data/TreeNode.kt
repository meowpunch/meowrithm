package data

class TreeNode(var `val`: Int) {
    constructor(`val`: Int, left: TreeNode, right: TreeNode) : this(`val`) {
        this.left = left
        this.right = right
    }

    var left: TreeNode? = null
    var right: TreeNode? = null
}