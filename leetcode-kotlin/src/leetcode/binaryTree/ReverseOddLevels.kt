package binaryTree

class ReverseOddLevels {
    class Solution {
        private var shouldReverse = false

        fun reverseOddLevels(root: TreeNode?): TreeNode? {
            if (root != null) {
                helper(root)
            }
            return root
        }

        private fun helper(root: TreeNode) {
            if (shouldReverse) {
                InvertBinaryTree.Solution().invertTree(root)
            }
            shouldReverse = !shouldReverse
            root.left?.let { helper(it) }
            root.right?.let { helper(it) }
        }
    }
}

fun main() {
    var root = TreeNode(7)
    root.left = TreeNode(13)
    root.right = TreeNode(11)

    root.printString()
    ReverseOddLevels.Solution().reverseOddLevels(root)?.printString()
}