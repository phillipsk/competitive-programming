package binaryTree

class SymmetricTree {
    class Solution {
        fun isSymmetric(root: TreeNode?): Boolean {
            val left = OrderLevelTraversalBFS().levelOrder(root?.left)
            val right = OrderLevelTraversalBFS().levelOrder(root?.right)
            val match = left == right.reversed()
            var m = false
            for (i in left.indices) {
                m = left[i] == right[i].reversed()
            }
            return m
        }
    }

    class EditorialSolution {
        fun isSymmetric(root: TreeNode?): Boolean {
            return isMirror(root, root)
        }

        fun isMirror(t1: TreeNode?, t2: TreeNode?): Boolean {
            if (t1 == null && t2 == null) {
                return true
            }
            return if (t1 == null || t2 == null) {
                false
            } else {
                (t1.`val` == t2.`val`
                        && isMirror(t1.right, t2.left)
                        && isMirror(t1.left, t2.right))
            }
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
}