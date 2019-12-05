package breadth_first_search;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode dfsHelp(int[] preorder,int preorderStar,int preorderEnd, int[] inorder,int inorderStar,int inorderEnd){
        if (preorderEnd > preorderStar || inorderEnd > inorderStar)
            return null;
        TreeNode root = new TreeNode(preorder[preorderStar]);
        for (int i=inorderStar;i<=inorderEnd;i++){
            if (preorder[preorderStar] == inorder[i]){
                root.left = dfsHelp(preorder,preorderStar+1,preorderStar+(i-inorderStar),inorder,inorderStar,i-1);
                root.right = dfsHelp(preorder,(i-preorderStar)+preorderStar+1,preorderEnd,inorder,i+1,inorderEnd);
            }
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return dfsHelp(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
}
