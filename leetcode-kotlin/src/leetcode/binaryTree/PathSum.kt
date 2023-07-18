package binaryTree


class PathSum {
    class Solution {
        var tempSumM = 0
        var tempSumA = mutableListOf<Int>()
        var hasTargetSum = false
        var targetSumM = 0
        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
            targetSumM = targetSum
            root?.let { helper(it) }
            return hasTargetSum
        }

        private fun helper(node: TreeNode) {

            val remain = targetSumM - tempSumM
            val shouldAdd = if (remain > 0) {
                node.`val` <= remain && !hasTargetSum
            } else {
                node.`val` >= remain && !hasTargetSum
            }
            if (shouldAdd) {
                tempSumM += node.`val`
//                tempSumA.add(node.`val`)
                if (tempSumM == targetSumM && node.left == null && node.right == null) {
                    hasTargetSum = true
                }
            }

            if (node.left != null) {
                helper(node.left!!)
            }
            if (node.right != null) {
                helper(node.right!!)
            }
        }
    }
}

fun main() {
//    Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    var root = TreeNode(5)

    root.left = TreeNode(4)
    root.left?.left = TreeNode(11)
    root.left?.right = null
    root.left?.left!!.left = TreeNode(7)
    root.left?.left!!.right = TreeNode(2)

    root.right = TreeNode(8)
    root.right!!.left = TreeNode(13)
    root.right!!.right = TreeNode(4)
    root.right!!.right?.right = TreeNode(1)

//    println(PathSum.Solution().hasPathSum(root, 22))

    root = TreeNode(1)
    root.left = TreeNode(2)
//    println(PathSum.Solution().hasPathSum(root, 1))

    root = TreeNode(1)
    root.left = TreeNode(-2)
    root.right = TreeNode(3)
    println(PathSum.Solution().hasPathSum(root, -2))

    root = TreeNode(1)
    root.left = TreeNode(-2)
    root.left!!.left = TreeNode(1)
    root.left!!.left?.left = TreeNode(-1)
    root.left!!.right = TreeNode(3)

    root.right = TreeNode(-3)
    root.right!!.left = TreeNode(-2)
//    println(PathSum.Solution().hasPathSum(root, 2))
}