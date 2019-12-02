package offer.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 求树的深度
 * @author Carlose wei
 * @version 1.0
 * @date 2019/12/2 14:40
 */
public class DepthTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int depthTree(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            depth++;
            while (size -->0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        System.out.println(new DepthTree().depthTree(root));
    }
}
