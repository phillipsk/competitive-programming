package binaryTree

// var ti = TreeNode(5)
// var v = ti.`val`
// * Definition for a binary tree node.
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun TreeNode.printString() {
    println(OrderLevelTraversalBFS().levelOrder(this))
}