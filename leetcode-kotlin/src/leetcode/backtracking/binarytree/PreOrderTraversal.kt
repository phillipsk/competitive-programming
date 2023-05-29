package backtracking.binarytree


class TreeNode(var `val`: Int) {
         var left: TreeNode? = null
         var right: TreeNode? = null
    }

internal class PreOrderTraversal {
    private val answer: MutableList<Int> = ArrayList()
    private fun dfs(node: TreeNode?) {
        if (node == null) {
            return
        }
        // Visit the root first, then the left subtree, then the right subtree.
        answer.add(node.`val`)
        dfs(node.left)
        dfs(node.right)
    }

    fun preorderTraversal(root: TreeNode?): List<Int> {
        dfs(root)
        return answer
    }
}

fun main() {
//    println(PreOrderTraversal().preorderTraversal())
}