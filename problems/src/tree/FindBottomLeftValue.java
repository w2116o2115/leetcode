package tree;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * 示例 1:
 *
 * 输入:
 *
 *     2
 *    / \
 *   1   3
 *
 * 输出:
 * 1
 *  
 *
 * 示例 2:
 *
 * 输入:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * 输出:
 * 7
 */
public class FindBottomLeftValue {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int maxDepth = -1, res = -1;

    public int findBottomLeftValue(TreeNode root) {
        helper(root,1);
        return res;
    }

    private void helper(TreeNode root,int level){
        if (root == null) return;
        if (maxDepth < level){
            maxDepth = level;
            res = root.val;
        }
        helper(root.left,level+1);
        helper(root.right,level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new FindBottomLeftValue().findBottomLeftValue(root));
    }
}