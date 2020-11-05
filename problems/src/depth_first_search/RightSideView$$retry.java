package depth_first_search;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. 二叉树的右视图
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1, 3, 4]
 * 解释:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 * <p>
 * 思路： 我们按照 「根结点 -> 右子树 -> 左子树」 的顺序访问.我们会最先访问右子树的节点
 */
public class RightSideView$$retry {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode root, List<Integer> res, int depth) {
        if (root == null)
            return;
        if (res.size() == depth) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, res, depth);
        dfs(root.left, res, depth);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        RightSideView$$retry rightSideView = new RightSideView$$retry();
        rightSideView.rightSideView(node);
    }
}