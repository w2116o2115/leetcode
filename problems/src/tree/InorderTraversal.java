package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void preOrder(TreeNode t) {  //先序遍历
        Stack<TreeNode> s = new Stack<>();
        while(t != null || !s.isEmpty()) {
            while(t != null) {
                System.out.println(t.val);  //第一次碰到就访问结点
                s.push(t);                //压栈保存，以便左边访问完了，之后可以弹出它得到它的右节点
                t = t.left;
            }
            if(!s.isEmpty()) {
                t = s.pop();
                t = t.right;      //当上述循环退出，说明左子树全访问完了，则把父结点弹出，准备访问右子树
            }
        }
    }

    public void inOrder(TreeNode t) {  //中序，与先序很像，只是在第二次碰到结点才访问
        Stack<TreeNode> s = new Stack<>();
        while(t != null || !s.isEmpty()) {
            while(t != null) {
                s.push(t);      //第一次碰到不访问，只保存
                t = t.left;
            }
            if(!s.isEmpty()) {
                t = s.pop();
                System.out.println(t.val);    //左子树访问完了，弹出父结点，第二次碰到则访问
                t = t.right;            //准备访问右子树
            }
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        new InorderTraversal().preOrder(root);
    }
}
