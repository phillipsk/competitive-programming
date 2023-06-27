package binaryTree

import java.util.*


/**
 * Given a binary tree, return the ______ traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,*,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 */

//    Pre-order traversal is to visit the root first. Then traverse the left subtree.
//    Finally, traverse the right subtree. Here is an example:
class PreOrderTraversal {
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

//  In-order traversal is to traverse the left subtree first. Then visit the root. Finally, traverse the right subtree.
class InOrderTraversal {
    internal class Solution {
        fun inorderTraversal(root: TreeNode?): List<Int> {
            val res: MutableList<Int> = ArrayList()
            helper(root, res)
            return res
        }

        fun helper(root: TreeNode?, res: MutableList<Int>) {
            if (root != null) {
                helper(root.left, res)
                res.add(root.`val`)
                helper(root.right, res)
            }
        }
    }
}

//  Post-order traversal is to traverse the left subtree first. Then traverse the right subtree. Finally, visit the root.
// 3,2,1
class PostOrderSolution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        helper(root, res)
        return res
    }

    private fun helper(root: TreeNode?, res: MutableList<Int>) {
        root?.let {
            helper(root.left, res)
            helper(root.right, res)
            res.add(root.`val`)
        }
    }
}

class Iterative {  // 1,2,3 // 1,2
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val answer: MutableList<Int> = ArrayList()
        val s = Stack<TreeNode?>()
        if (root != null) {
            s.push(root)
        }
        var cur: TreeNode?
        while (!s.empty()) {
            cur = s.pop()
            answer.add(cur!!.`val`) // visit the root
            if (cur.right != null) {
                s.push(cur.right) // push right child to stack if it is not null
            }
            if (cur.left != null) {
                s.push(cur.left) // push left child to stack if it is not null
            }
        }
        return answer
    }
}

fun main() {
    var root = TreeNode(1)
    root.right = TreeNode(2)
    root.right?.left = TreeNode(3)
//    println(PreOrderTraversal().preorderTraversal(root))
//    println(InOrderTraversal.Solution().inorderTraversal(root))
//    println(PostOrderSolution().postorderTraversal(root))
    println(Iterative().preorderTraversal(root))

    root = TreeNode(1)
    root.left = TreeNode(2)
//    println(PostOrderSolution().postorderTraversal(root))
    println(Iterative().preorderTraversal(root))
}