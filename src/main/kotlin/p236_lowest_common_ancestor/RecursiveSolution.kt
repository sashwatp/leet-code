package p236_lowest_common_ancestor

class TreeNode(var value: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val root = createTree(arrayOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4))

    println(
        RecursiveSolution().lowestCommonAncestor(
            root,
            TreeNode(5),
            TreeNode(1)
        )?.value
    )
}

class RecursiveSolution {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        if (root == p || root == q) {
            return root
        }

        val left = lowestCommonAncestor(root?.left, p, q)
        val right = lowestCommonAncestor(root?.right, p, q)

        return if (left != null && right != null) {
            root
        } else {
            left ?: right
        }
    }
}

fun createTree(intArray: Array<Int?>): TreeNode? {
    if (intArray[0] == null) {
        return null
    }

    val root = TreeNode(intArray[0]!!)

    var nodeArray = arrayOfNulls<TreeNode>(intArray.size)

    intArray.forEachIndexed { index, i ->
        nodeArray[index] = i?.let { TreeNode(it) }

        if (index != 0) {
            if (index % 2 != 0) {
                nodeArray[(index - 1) / 2]?.left = nodeArray[index]
            } else {
                nodeArray[(index - 1) / 2]?.right = nodeArray[index]
            }
        }
    }

    return nodeArray[0]
}