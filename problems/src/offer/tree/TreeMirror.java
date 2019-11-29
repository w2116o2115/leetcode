package offer.tree;

/**
 * 创建树的镜像
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/29 11:17
 */
public class TreeMirror {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void mirror(TreeNode root){
        if (root == null){
            return ;
        }
        //交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        mirror(root.left);
        mirror(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        new TreeMirror().mirror(root);
        System.out.println(1);
    }
}
