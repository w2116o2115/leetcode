package top100;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class ConvertBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int add = 0;
    //BST的中序遍历就是从小到大,那么反过来就是从大到小,然后累加就好了
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return root;
        convertBST(root.right);//遍历右子树
        root.val += add;//遍历顶点
        add = root.val;
        convertBST(root.left);//遍历左子树
        return root;
    }
}
