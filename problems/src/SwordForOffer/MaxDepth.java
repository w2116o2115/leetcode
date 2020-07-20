package SwordForOffer;

/**
 * 剑指 Offer 55 - I. 二叉树的深度
 */
public class MaxDepth {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = 1;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        dfs(root,1);
        return res;
    }

    private void dfs(TreeNode root,int level){
        if (root == null) return;
        if (res < level) res = level;
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(7);
        System.out.println(new MaxDepth().maxDepth(node1));
    }
}