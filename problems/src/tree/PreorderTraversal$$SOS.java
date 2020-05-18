package tree;

import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreorderTraversal$$SOS {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void preorderTraversal(TreeNode head) {
        if(head == null){
            System.out.println("二叉树为空");
            return;
        }
        System.out.println("先序遍历，非递归方式");
        Stack<TreeNode> s = new Stack<>();
        s.push(head);
        while( !s.isEmpty() ){
            head = s.pop();
            System.out.print(head.val+", ");
            if(head.right != null){
                s.push(head.right);
            }
            if(head.left != null){
                s.push(head.left);
            }
        }
    }

    public static void main(String[] args) {
        //创建二叉树节点
        TreeNode head = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(7);
        //生成二叉树
        head.left = n1;
        head.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        //非递归方式，先序遍历二叉树
        preorderTraversal(head);
    }
}