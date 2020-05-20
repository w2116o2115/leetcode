package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 *
 * 思路  对树进行序列化  2 4 #  每棵不同子树的序列化结果都是唯一的。
 */
public class FindDuplicateSubtrees$$SOS {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<TreeNode,Integer> map = new ConcurrentHashMap<>();
        helper(root,map);
        map.entrySet().forEach((entry->{
            if (entry.getValue() > 1) res.add(entry.getKey());
        }));
        return res;
    }

    private void helper(TreeNode root,Map<TreeNode,Integer> map){
        if (root == null) return;
        boolean flag = true;
        for (TreeNode node:map.keySet()){
            if (diffTreeNode(node,root)) {
                map.put(node, map.getOrDefault(node,0) + 1);
                flag = !flag;
            }
        }
        if (flag) map.put(root,1);
        helper(root.left,map);
        helper(root.right,map);
    }

    private boolean diffTreeNode(TreeNode node1,TreeNode node2){
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        return diffTreeNode(node1.left,node2.left) && diffTreeNode(node1.right,node2.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        new FindDuplicateSubtrees$$SOS().findDuplicateSubtrees(root);
    }
}