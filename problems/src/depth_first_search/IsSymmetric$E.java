package depth_first_search;

/**
 * 101. 对称二叉树
 *
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
public class IsSymmetric$E {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root) {
        return dfs(root,root);
    }

    private boolean dfs(TreeNode left,TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return (left.val == right.val) && dfs(left.right,right.left) && dfs(left.left,right.right);
    }
}
