package tencent;

/**
 * 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 */
public class KthSmallest {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    int res = 0;
    int index = 1;

    public int kthSmallest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }

    public void dfs(TreeNode root,int target){
        if (root == null) return;
        dfs(root.left,target);
        if (index == target) {
            res = root.val;
        }
        index+=1;
        dfs(root.right,target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(new KthSmallest().kthSmallest(root,2));
    }
}