package tree;

/**
 * 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 思路 : 后续遍历，先处理左边  右边，
 *        不能走进一个分支又掉头回来走另一个分支，路径会重叠，不符合定义。
 */
public class MaxPathSum$$retry {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root){
        if (root == null) return 0;
        int left = Math.max(0,helper(root.left));
        int right = Math.max(0,helper(root.right));
        int sum = left + right + root.val;
        max = Math.max(max,sum);
        return root.val + Math.max(left,right); //由于只能走进一个分支，所以只能选择左边或者右边
    }
}