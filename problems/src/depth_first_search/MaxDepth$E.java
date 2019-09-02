package depth_first_search;

/**
 *  二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class MaxDepth$E {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(7);
        System.out.println(maxDepth(node1));
    }

    public static int maxDepth(TreeNode root) {
        int level = 0;
        return dsf(root,root,level);
    }

    private static int dsf(TreeNode left, TreeNode right, int level){
        if (left != null && right != null)
            return Math.max(dsf(left.left,left.right,level+1),dsf(right.left,right.right,level+1));
        if (left != null && right == null)
            return Math.max(dsf(left.left,left.right,level+1),level);
        if (left == null && right != null)
            return Math.max(dsf(right.left,right.right,level+1),level);
        return level;
    }
}
