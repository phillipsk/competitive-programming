package binaryTree


class OrderLevelTraversalBFS {
    var levels: MutableList<MutableList<Int>> = ArrayList()

    fun helper(node: TreeNode?, level: Int) {
        // start the current level
        if (levels.size == level) {
            levels.add(ArrayList()) // change to new level
        }

        // fulfil the current level
        levels[level].add(node!!.`val`)

        // process child nodes for the next level
        if (node.left != null) {
            helper(node.left, level + 1) // change to new level
        }
        if (node.right != null) {
            helper(node.right, level + 1) // change to new level
        }
    }

    fun levelOrder(root: TreeNode?): List<MutableList<Int>> {
        if (root == null) return levels
        helper(root, 0)
        return levels
    }
}


fun main() {
    var root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left = TreeNode(15)
    root.right!!.right = TreeNode(7)

    println(OrderLevelTraversalBFS().levelOrder(root))
}