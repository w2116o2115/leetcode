package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 */
public class LargestValues {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        helper(root,map,1);
        return new ArrayList<>(map.values());
    }

    private void helper(TreeNode root,Map<Integer,Integer> map,int level){
        if (root == null) return;

        map.put(level,Math.max(root.val,map.getOrDefault(level,root.val)));
        helper(root.left,map,level+1);
        helper(root.right,map,level+1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);
        System.out.println(new LargestValues().largestValues(root));
    }
}