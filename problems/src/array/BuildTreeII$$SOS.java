package array;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class BuildTreeII$$SOS {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,postorder,postorder.length-1,0,inorder.length-1);
    }

    public TreeNode build(int[] inorder, int[] postorder,int postorderEnd,int inorderStar,int inorderEnd){
        if (inorderStar>inorderEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postorderEnd]);
        for (int i=inorderStar;i<=inorderEnd;i++){
            if (postorder[postorderEnd] == inorder[i]){
                root.left = build(inorder,postorder,postorderEnd-(inorderEnd-i)-1,inorderStar,i-1);
                root.right = build(inorder,postorder,postorderEnd-1,i+1,inorderEnd);
            }
        }
        return root;
    }
}