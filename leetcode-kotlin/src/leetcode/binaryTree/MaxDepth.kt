package binaryTree

class MaxDepthSolution {
    var counter = 0

    fun helper(node: TreeNode?, level: Int) {
        // start the current level
        if (counter == level) {
            counter++ // change to new level
        }

        // process child nodes for the next level
        if (node?.left != null) {
            helper(node.left, level + 1) // change to new level
        }
        if (node?.right != null) {
            helper(node.right, level + 1) // change to new level
        }
    }
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return counter
        helper(root, 0)
        return counter
    }
}

fun main() {
    var root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)

    println(MaxDepthSolution().maxDepth(root))
}