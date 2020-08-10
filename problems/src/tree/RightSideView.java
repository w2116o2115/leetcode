package tree;

import SwordForOffer.MaxDepth;

import java.util.*;

/**
 * 199. 二叉树的右视图
 *
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class RightSideView {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = Integer.MIN_VALUE;

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        helper(map,root,1);
        return new ArrayList<>(map.values());
    }

    private void helper(Map<Integer,Integer> map,TreeNode root,int level){
        if (root == null) return;
        if (level > max){
            map.put(level,root.val);
            max = level;
        }
        helper(map,root.right,level+1);
        helper(map,root.left,level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        System.out.println(new RightSideView().rightSideView(root));
    }
}