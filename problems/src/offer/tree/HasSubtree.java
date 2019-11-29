package offer.tree;

/**
 * 判断树A 是树B的子树
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/29 10:57
 */
public class HasSubtree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean restult = false;
        if (root1 != null && root2 !=null){
            if (root1.val == root2.val){//找到了公共起点
                restult = doseTree1HasTree2(root1,root2);
            }

            if (!restult){
                restult = HasSubtree(root1.left,root2);
            }

            if (!restult){
                restult = HasSubtree(root1.right,root2);
            }
        }
        return restult;
    }

    private boolean doseTree1HasTree2(TreeNode tree1,TreeNode tree2){
        if (tree2 == null){
            return true;
        }
        if (tree1 == null){
            return false;
        }
        if (tree1.val != tree2.val){
            return false;
        }
        return doseTree1HasTree2(tree1.left,tree2.left) && doseTree1HasTree2(tree1.right,tree2.right);
    }
}
