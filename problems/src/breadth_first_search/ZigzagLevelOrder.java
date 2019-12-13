package breadth_first_search;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class ZigzagLevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty() || !stack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if (!queue.isEmpty()){
                int count = queue.size();
                while (count --> 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) stack.push(node.left);
                    if (node.right != null) stack.push(node.right);
                    list.add(node.val);
                }
                res.add(list);
            }else {
                int count = stack.size();
                while (count -->0){
                    TreeNode node = stack.pop();
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                    list.add(node.val);
                }
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(root));
    }
}
