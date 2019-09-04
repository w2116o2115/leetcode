package depth_first_search;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 示例:
 *
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 */
public class RightSideView$M {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dsf(root,result,0);
        System.out.println(result);
    }

    public void dsf(TreeNode node,List<Integer> list,int level){
        if (node == null)
            return;
        if (list.size() == level)
            list.add(node.val);
        dsf(node.right,list,level+1);
        dsf(node.left,list,level+1);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(4);
        RightSideView$M rightSideView$M = new RightSideView$M();
        rightSideView$M.rightSideView(node);
    }
}
