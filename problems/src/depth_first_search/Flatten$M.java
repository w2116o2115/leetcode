package depth_first_search;

/**
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Flatten$M {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode last = null;
    private static void recursion(TreeNode root) {
        if (root == null) return;
        // 前序：注意更新last节点，包括更新左右子树
        if (last != null) {
            last.left = null;
            last.right = root;
        }
        last = root;
        // 前序：注意备份右子节点，规避下一节点篡改
        TreeNode copyRight = root.right;
        recursion(root.left);
        recursion(copyRight);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);
        node.right.right = new TreeNode(6);
        recursion(node);
        System.out.println(1);
    }
}
