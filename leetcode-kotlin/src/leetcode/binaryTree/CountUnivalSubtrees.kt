package binaryTree

class CountUnivalSubtrees {
    fun countUnivalSubtrees(root: TreeNode?): Int {
        val list = mutableListOf<Int>()

        root?.let { helper(it, list) } ?: 0
        val common = list.maxBy { it }
        return list.count { it == common }
    }

    private fun helper(root: TreeNode, list: MutableList<Int>) {

        val isLeafNode = (root.left?.`val` == null && root.right?.`val` == null)
        val isUniValueNode = (root.left?.`val` == null && root.right?.`val` == root.`val`) ||
                (root.right?.`val` == null && root.left?.`val` == root.`val`)
        if (isLeafNode || isUniValueNode) {
            list.add(root.`val`)
        }

        root.left?.let {
            helper(it, list)
        }
        root.right?.let {
            helper(it, list)
        }
    }
}

fun main() {
    var root = TreeNode(5)

    root.left = TreeNode(1)
    root.left?.left = TreeNode(5)
    root.left?.right = TreeNode(5)

    root.right = TreeNode(5)
    root.right?.right = TreeNode(5)

    print(CountUnivalSubtrees().countUnivalSubtrees(root))
}