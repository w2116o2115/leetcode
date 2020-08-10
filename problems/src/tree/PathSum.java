package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfsHelper(res,root,sum,new Stack<>());
        return res;
    }

    private void dfsHelper(List<List<Integer>> res, TreeNode root, int sum, Stack<Integer> stack){
        if (root == null) return;
        stack.add(root.val);
        if (sum == root.val && root.left == null && root.right == null){
            res.add(new ArrayList<>(stack));
        }

        dfsHelper(res,root.left,sum-root.val,stack);
        dfsHelper(res,root.right,sum-root.val,stack);
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        TreeNode t1 = new TreeNode(11);
        TreeNode t2 = new TreeNode(13);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(1);
        root.left.left = t1;
        t1.left = t4;
        t1.right = t5;
        root.right.left = t2;
        root.right.right = t3;
        t3.left = t6;
        t3.right = t7;

        System.out.println(new PathSum().pathSum(root,22));
    }
}