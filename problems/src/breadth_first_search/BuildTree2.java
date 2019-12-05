package breadth_first_search;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 *
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]    i=1  left 0 0  right 2 4  i =3  left 2 2 right 4 4     2 4
 * 后序遍历 postorder = [9,15,7,20,3]   i=1  left 0 0  right 1 3  i =3  left 1 1 right 2 2     1 3
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode dfsHelp(int[] inorder, int[] postorder,int inorderStar,int inorderEnd,int postorderStar,int postorderEnd){
        if (postorderEnd < postorderStar || inorderEnd < inorderStar){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderEnd]);
        for(int i=0;i<=inorderEnd;i++){
            if (postorder[postorderEnd] == inorder[i]){
                root.left = dfsHelp(inorder,postorder,inorderStar,i-1,postorderStar,postorderEnd-i-1);
                root.right = dfsHelp(inorder,postorder,i+1,inorderEnd,postorderStar+(i-inorderStar),postorderEnd-(i-inorderStar));
            }
        }
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null) {
            return null;
        }
        return dfsHelp(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = new BuildTree2().buildTree(inorder,postorder);
        System.out.println(1);
    }
}
