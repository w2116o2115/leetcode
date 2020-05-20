package tree;

import java.util.*;

/**
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 *  
 *
 * 示例 1：
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 */
public class FindFrequentTreeSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxFrequency = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        helper(root,map);
        return map.entrySet().stream().filter(entry -> entry.getValue().equals( maxFrequency)).mapToInt(Map.Entry::getKey).toArray();
    }

    private int helper(TreeNode root,Map<Integer,Integer> map){
        int sum = 0;
        if (root == null) return sum;
        if (root.left == null && root.right == null) {
            map.put(root.val,map.getOrDefault(root.val,0)+1);
            return root.val;
        }
        int left= helper(root.left,map);
        int right = helper(root.right,map);
        sum += (root.val + left + right);
        map.put(sum,map.getOrDefault(sum,0)+1);
        maxFrequency = map.get(sum) > maxFrequency ? map.get(sum) : maxFrequency;
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        System.out.println(Arrays.toString(new FindFrequentTreeSum().findFrequentTreeSum(root)));
    }
}