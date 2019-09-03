package depth_first_search;

import java.util.*;

/**
 * 113. 路径总和 II
 * <p>
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSum$M {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static Stack<Integer> stack = new Stack<>();
    private static List<List<Integer>> result = new ArrayList<>();
    private static int target = 22;

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, sum, res, new Stack<>());
        return res;
    }

    private static void helper(TreeNode root, int sum, List<List<Integer>> res, Stack<Integer> stack) {
        if (root == null) return;
        stack.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0)
            res.add(new ArrayList<>(stack));
        helper(root.left, sum - root.val, res, stack);
        helper(root.right, sum - root.val, res, stack);
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(2);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);
        System.out.println(pathSum(treeNode,22));
    }
}
