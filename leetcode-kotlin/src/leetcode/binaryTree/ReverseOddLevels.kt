package binaryTree

class ReverseOddLevels {
    class Solution {
        private var shouldReverse = true

        fun reverseOddLevels(root: TreeNode?): TreeNode? {
            if (root != null) {
                helper(root.left, root.right)
            }
            return root
        }

        private fun helper(t1: TreeNode?, t2: TreeNode?) {
            if (shouldReverse && t1 != null && t2 != null) {
                val tmp = t1.`val`
                t1.`val` = t2.`val`
                t2.`val` = tmp
            }
            shouldReverse = !shouldReverse
            if (t1 != null && t2 != null) {
                helper(t1.left, t2.left)
                helper(t1.right, t2.right)
                shouldReverse = !shouldReverse
            }
        }
    }
}

fun main() {
    var root = TreeNode(7)
    root.left = TreeNode(13)
    root.right = TreeNode(11)

//    root.printString()
//    ReverseOddLevels.Solution().reverseOddLevels(root)?.printString()

    root = TreeNode(2)
    root.left = TreeNode(3)
    root.left!!.left = TreeNode(7)
    root.left!!.left!!.left = TreeNode(19)
    root.left!!.left!!.right = TreeNode(23)

    root.left!!.right = TreeNode(11)
    root.left!!.right!!.left = TreeNode(29)
    root.left!!.right!!.right = TreeNode(31)

    root.right = TreeNode(5)
    root.right!!.left = TreeNode(13)
    root.right!!.left!!.left = TreeNode(37)
    root.right!!.left!!.right = TreeNode(41)

    root.right!!.right = TreeNode(17)
    root.right!!.right!!.left = TreeNode(43)
    root.right!!.right!!.right = TreeNode(47)

    root.printString()
    ReverseOddLevels.Solution().reverseOddLevels(root)?.printString()
}