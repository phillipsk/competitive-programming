package binaryTree

class SymmetricTree {
    class Solution {
        fun isSymmetric(root: TreeNode?): Boolean {
            return if (root != null && (root.left != null && root.right != null)) {
                helper(root.left!!, root.right!!)
            } else if (root != null){
                return true
            } else {
                false
            }
        }

        private fun helper(t1: TreeNode, t2: TreeNode): Boolean {
            val b = t1.`val` == t2.`val`
            if (t1.left != null && t2.right != null) {
                helper(t1.left!!, t2.right!!)
            } else {
                return false
            }
            if (t1.right != null && t2.left != null) {
                helper(t1.right!!, t2.left!!)
            } else {
                return false
            }
            return b
        }
    }
}

fun main() {
    var root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left!!.left = TreeNode(3)
    root.left!!.right = TreeNode(4)
    root.right!!.left = TreeNode(4)
    root.right!!.right = TreeNode(3)

    println(SymmetricTree.Solution().isSymmetric(root))
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(2)
    root.left!!.left = null
    root.left!!.right = TreeNode(3)
    root.right!!.left = null
    root.right!!.right = TreeNode(3)

    println(SymmetricTree.Solution().isSymmetric(root))

    root = TreeNode(1)
    println(SymmetricTree.Solution().isSymmetric(root))
}