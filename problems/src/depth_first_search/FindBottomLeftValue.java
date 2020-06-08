package depth_first_search;

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
        TreeNode(int x) { val = x; }
    }

    private int maxLevel = 0;
    private int res = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfsHelper(root,0);
        return res;
    }

    private void dfsHelper(TreeNode root,int level){
        if (root == null) return;
        if (maxLevel < level){
            res = root.val;
            maxLevel = level;
        }
        dfsHelper(root.left,level+1);
        dfsHelper(root.right,level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new FindBottomLeftValue().findBottomLeftValue(root));
    }
}