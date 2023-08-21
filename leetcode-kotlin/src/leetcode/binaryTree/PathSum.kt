package binaryTree


class PathSum {
    class Solution {
        var tempSum = 0
        var hasTargetSum = false
        var targetSumM = 0
        fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
            targetSumM = targetSum
            root?.let { helper(it, root.`val`, false) }
            return hasTargetSum
        }

        private fun helper(node: TreeNode, rootNode: Int, isEndOfLeaf: Boolean) {
//            val isEndOfLeaf = node.left == null && node.right == null

            val remain = if (targetSumM >= 0) {
                targetSumM - tempSum
            } else {
                targetSumM + tempSum
            }
            val shouldAdd = if (remain >= 0) {
                node.`val` <= remain && !hasTargetSum
            } else {
                node.`val` >= remain && !hasTargetSum
            }
            if (shouldAdd) {
                tempSum += node.`val`
                if (tempSum == targetSumM) {
                    hasTargetSum = true
                }
            }

            if (node.left != null) {
                helper(node.left!!, rootNode, node.right == null)
            } // else if
            if (node.right != null) {
                helper(node.right!!, rootNode, node.left == null)
            }
            if (isEndOfLeaf && !hasTargetSum) {
                tempSum = rootNode
            } // TODO: else
        }
    }

    internal class EditorialSolution {
        fun hasPathSumOld(root: TreeNode?, sum: Int): Boolean {
            var sum = sum
            if (root == null) {
                return false
            }
            sum -= root.`val`
            val hasPathSumLH = hasPathSum(root.left, sum)
            val hasPathSumRH = hasPathSum(root.right, sum)
            return hasPathSumLH || hasPathSumRH
        }

        fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
            if (root == null) {
                return false
            } else if (root.left == null && root.right == null && root.`val` == sum) {
                return true
            }
            val hasPathSumLH = hasPathSum(root.left, sum - root.`val`)
            val hasPathSumRH = hasPathSum(root.right, sum - root.`val`)
            return hasPathSumLH || hasPathSumRH
        }
    }
}

fun main() {
//    Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    var root = TreeNode(5)

    root.left = TreeNode(4)
    root.left?.left = TreeNode(11)
    root.left?.left!!.left = TreeNode(7)
    root.left?.left!!.right = TreeNode(2)

    root.right = TreeNode(8)
    root.right!!.left = TreeNode(13)
    root.right!!.right = TreeNode(4)
    root.right!!.right?.right = TreeNode(1)

    println(PathSum.EditorialSolution().hasPathSum(root, 22))

    root = TreeNode(1)
    root.left = TreeNode(2)
//    println(PathSum.Solution().hasPathSum(root, 1))

    root = TreeNode(1)
    root.left = TreeNode(-2)
    root.right = TreeNode(3)
//    println(PathSum.Solution().hasPathSum(root, -2))

    root = TreeNode(1)
    root.left = TreeNode(-2)
    root.left!!.left = TreeNode(1)
    root.left!!.left?.left = TreeNode(-1)
    root.left!!.right = TreeNode(3)

    root.right = TreeNode(-3)
    root.right!!.left = TreeNode(-2)
//    println(PathSum.Solution().hasPathSum(root, -4))
}

/*
* Testcases
*
[5,4,8,11,null,13,4,7,2,null,null,null,1]
22
[1,2,3]
5
[]
0
[-2,null,-3]
-3
[1,-2,3]
-2
[1,-2,-3,1,3,-2,null,-1]
2
[1,-2,-3,1,3,-2,null,-1]
1
[1,-2,-3,1,3,-2,null,-1]
-1
*
* */