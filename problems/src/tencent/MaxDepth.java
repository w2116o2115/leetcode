package tencent;

import tree.AddOneRow;

import java.util.Map;

/**
 * @author carlos zhang
 * @date 2020/7/4 上午11:17
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

    private static int maxDepth=Integer.MIN_VALUE;

    public static int maxDepth(TreeNode root) {
        dfs(root,1);
        return maxDepth;
    }

    private static void dfs(TreeNode node,int level){
        if (node == null) return;

        maxDepth = Math.max(maxDepth,level);

        if (node.left != null) dfs(node.left,level+1);
        if (node.right != null) dfs(node.right,level+1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(20);
        node1.right.left = new TreeNode(15);
        node1.right.right = new TreeNode(7);
        System.out.println(maxDepth(node1));
    }
}
