package depth_first_search;

import java.util.ArrayList;
import java.util.List;

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
public class LargestValues$M {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dsf(root,list,0);
        return list;
    }

    private void dsf(TreeNode node,List<Integer> list,int level){
        if (node == null)
            return;
        if (list.size() == level)
            list.add(node.val);
        list.set(level,Math.max(list.get(level),node.val));
        dsf(node.left,list,level+1);
        dsf(node.right,list,level+1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(5);
        node.left.right = new TreeNode(3);
        node.right.right = new TreeNode(9);
        System.out.println(new LargestValues$M().largestValues(node));
    }
}
