package offer.tree;

/**
 *
 * 前序遍历为：（4，7，9，2，1，5，6）
 * 中序遍历为：（7，9，4，1，2，6，5）
 * 后序遍历为：（9，7，1，6，5，2，4）
 *
 * 通过先序遍历 和 中序遍历 重建二叉树
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/29 10:32
 */
public class RebuildBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // 构建二叉树的核心算法
    public TreeNode rebuildBinaryTreeCore(int preorder[], int startPreorder,
                                          int endPreorder, int inorder[], int startInorder, int endInorder) {
        if (startPreorder > endPreorder || startInorder > endInorder) { //停止递归的条件
            return null;
        }
        TreeNode root = new TreeNode(preorder[startPreorder]);
        for (int i = startInorder; i <= endInorder; i++) {
            if (preorder[startPreorder] == inorder[i]) {
                // 其中（i - startInorder）为中序排序中左子树结点的个数
                //左子树
                root.left = rebuildBinaryTreeCore(preorder, startPreorder + 1,
                        startPreorder + (i - startInorder), inorder,
                        startInorder, i - 1);
                //右子树
                root.right = rebuildBinaryTreeCore(preorder, (i - startInorder)
                                + startPreorder + 1, endPreorder, inorder, i + 1,
                        endInorder);

            }
        }
        return root;
    }

    public TreeNode buildTree(int preorder[], int inorder[]) {
        if (preorder == null || inorder == null) { //如果前序或者中序有一个是空直接返回
            return null;
        }
        TreeNode root = rebuildBinaryTreeCore(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
        return root;
    }
}
