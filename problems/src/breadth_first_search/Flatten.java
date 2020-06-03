package breadth_first_search;

/**
 * 114. 二叉树展开为链表
 *
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 *  将左子树  插到又子树的地方
 *  //将 1 的左子树插入到右子树的地方
 *     1
 *      \
 *       2         5
 *      / \         \
 *     3   4         6
 * //将原来的右子树接到左子树的最右边节点
 *     1
 *      \
 *       2
 *      / \
 *     3   4
 *          \
 *           5
 *            \
 *             6
 *
 *  //将 2 的左子树插入到右子树的地方
 *     1
 *      \
 *       2
 *        \
 *         3       4
 *                  \
 *                   5
 *                    \
 *                     6
 */
public class Flatten {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode pre = null;

    /**
     * 利用  前序遍历 输出每一个点  然后逐个点的去链接
     * public void PrintBinaryTreeBacRecur(TreeNode<T> root){
     *     if (root == null)
     *         return;
     *
     *     PrintBinaryTreeBacRecur(root.right);
     *     PrintBinaryTreeBacRecur(root.left);
     *     System.out.print(root.data);
     *
     * }
     * @param root
     */

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        System.out.println(root.val);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(6);
        root.left.left = t1;
        root.left.right = t2;
        root.right.right = t3;

        new Flatten().flatten(root);
    }
}
