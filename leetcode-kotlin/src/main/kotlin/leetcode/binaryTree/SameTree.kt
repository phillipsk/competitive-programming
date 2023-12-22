package binaryTree

class SameTree {
    class Solution {
        fun isSameTree(t1: TreeNode?, t2: TreeNode?): Boolean {
            if (t1 == null && t2 == null) {
                return true // return ends recursion
            }
            return if (t1 == null || t2 == null) {
                false
            } else {
                val b = t1.`val` == t2.`val`
                val mirrorRH = isSameTree(t1.right, t2.right)
                val mirrorLH = isSameTree(t1.left, t2.left)
                return (b && mirrorRH && mirrorLH)
            }
        }

    }
}

fun main() {
    var root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)

    val root1 = TreeNode(1)
    root1.left = TreeNode(2)
    root1.right = TreeNode(3)

    println(SameTree.Solution().isSameTree(root, root1))
}