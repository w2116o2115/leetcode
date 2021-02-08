package tree;

/**
 * 968. 监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 * 示例 1：
 *
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 *
 * 分析： 二叉树  可以有 前 中 后三种遍历方式
 *       本题中，root节点是否放箱机，取决孩子节点的状态，所以考虑用后续遍历
 *       考虑每个节点的状态  1 放照相机  2 不放照相机 但是可以被覆盖到  0 没有被箱机覆盖到（必须孩子节点都是null）
 */
public class MinCameraCover$$retry {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*
        0 cannot be covered
        1 put a camera here
        2 no camera can be covered(is null)
     */
    int total = 0;
    public int minCameraCover(TreeNode root) {
        if (helper(root) == 0){
            total += 1;
        }
        return total;
    }

    private int helper(TreeNode root) {
        if (root == null) return 2;
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == 0 || right == 0){
            total+=1;
            return 1;
        }
        if (left == 2 && right == 2){
            return 0;
        }else {
            return 2;
        }
    }
}