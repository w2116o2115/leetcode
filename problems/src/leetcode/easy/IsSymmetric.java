package leetcode.easy;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 */
public class IsSymmetric {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 != null)
            return false;
        if (node2 == null && node1 != null)
            return false;
        if (node1 == null && node2 == null)
            return true;
        if (node1.val != node2.val){
            return false;
        }
        return dfs(node1.left,node2.right) && dfs(node1.right,node2.left);
    }
}
