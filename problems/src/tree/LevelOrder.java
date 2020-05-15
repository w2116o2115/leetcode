package tree;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer,List<Integer>> map = new TreeMap<>();
        dsf(root,map,0);
        return new ArrayList<>(map.values());
}

    private void dsf(TreeNode node, Map<Integer,List<Integer>> res,int level){
        if (node == null) return;
        if (!res.containsKey(level)) {
            res.put(level,new ArrayList<>());
        }
        res.get(level).add(node.val);

        dsf(node.left,res,level+1);
        dsf(node.right,res,level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new LevelOrder().levelOrder(root));
    }
}