package binaryTree

class InvertBinaryTree {
    class Solution {
        fun invertTree(root: TreeNode?): TreeNode? {
            if (root != null) {
                helper(root)
            }
            return root
        }

        private fun helper(root: TreeNode) {
            val tmp = root.left
            root.left = root.right
            root.right = tmp
            root.left?.let { helper(it) }
            root.right?.let { helper(it) }
        }
    }
}

fun main() {
    var root = TreeNode(4)
    root.left = TreeNode(2)
    root.left?.left = TreeNode(1)
    root.left?.right = TreeNode(3)

    root.right = TreeNode(7)
    root.right?.left = TreeNode(6)
    root.right?.right = TreeNode(9)

    root.printString()
    InvertBinaryTree.Solution().invertTree(root)?.printString()
}