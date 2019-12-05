package breadth_first_search;

/**
 * 98. 验证二叉搜索树
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class IsValidBST {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private boolean dfsHelp(TreeNode root,Integer isMax,Integer isMin){
        if (root == null)
            return true;
        if (isMax != null && root.val >= isMax){
            return false;
        }
        if (isMin != null && root.val <= isMin){
            return false;
        }
        return (dfsHelp(root.left,root.val,isMin)) && (dfsHelp(root.right,isMax,root.val));
    }

    public boolean isValidBST(TreeNode root) {
        return dfsHelp(root,null,null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left = new TreeNode(1);
        System.out.println(new IsValidBST().isValidBST(root));
    }
}
