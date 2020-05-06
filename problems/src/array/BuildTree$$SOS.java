package array;

/**
 * 105. 从前序与中序遍历序列构造二叉树
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
 * 思路：先序序列的第一个节点是根节点，凭此去遍历中序序列，得到中序遍历根节点的位置，
 * 于是可以从中序遍历得出左右子树的结点数，再以同样的方式去递归求出左子树结点和右子树结点
 */
public class BuildTree$$SOS {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return dfsBuild(preorder,0,inorder,0,inorder.length-1);
    }

    private TreeNode dfsBuild(int[] preOrder,int preOrderStar,int[] inorder,int inorderStar,int inorderEnd){
        if (inorderStar>inorderEnd)
            return null;
        TreeNode root = new TreeNode(preOrder[preOrderStar]);
        for (int i = inorderStar;i<=inorderEnd;i++){
            if (preOrder[preOrderStar] == inorder[i]){
                root.left = dfsBuild(preOrder,preOrderStar+1,inorder,inorderStar,i-1);
                root.right = dfsBuild(preOrder,(i-inorderStar)+preOrderStar+1,inorder,i+1,inorderEnd);// (i-inorderStar)获取左树的元素数
            }
        }
        return root;
    }
}