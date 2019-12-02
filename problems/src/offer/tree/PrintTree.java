package offer.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2019/12/2 10:44
 */
public class PrintTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String printTree(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size --> 0){
                TreeNode node = queue.poll();
                sb.append(node.val);
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new PrintTree().printTree(root));
    }
}
