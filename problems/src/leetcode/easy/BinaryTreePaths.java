package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 */
public class BinaryTreePaths {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root,"",res);
        return res;
    }

    private void dfs(TreeNode root,String str,List<String> res){
        if (root == null)
            return;
        if (root.left == null && root.right == null){
            str = "".equals(str)?""+ root.val:str+"->"+root.val;
            res.add(str);
            return;
        }
        dfs(root.left,"".equals(str)?""+ root.val:str+"->"+root.val,res);
        dfs(root.right,"".equals(str)?""+ root.val:str+"->"+root.val,res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        System.out.println(new BinaryTreePaths().binaryTreePaths(root));
    }
}
