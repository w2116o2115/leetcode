package tree;

import java.util.Stack;

/**
 * 114. 二叉树展开为链表
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Flatten {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        helper(root,new Stack<>());
        System.out.println(1);
    }

    private void helper(TreeNode root, Stack<TreeNode> stack){
        TreeNode master = new TreeNode(-1);
        master.right = root;
        while (root.left!=null) {
            if (root.right != null) {
                stack.add(root.right);
            }
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
        TreeNode current = master.right;
        while (!stack.isEmpty()){
            while (current.right!=null){
                current = current.right;
            }
            current.right = stack.pop();
        }
        root = master.right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        new Flatten().flatten(root);
    }
}