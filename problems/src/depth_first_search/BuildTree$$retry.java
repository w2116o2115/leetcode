package depth_first_search;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * @
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
public class BuildTree$$retry {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int pre_idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int idx = 0;
        for (int val : inorder)
            idx_map.put(val,idx++);
        return dsf(pre_idx,inorder.length);
    }

    private TreeNode dsf(int in_left,int in_right){
        if (in_left == in_right)
            return null;
        int root_val = preorder[pre_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        pre_idx++;
        root.left = dsf(in_left,index);
        root.right = dsf(index+1,in_right);
        return root;
    }
}
