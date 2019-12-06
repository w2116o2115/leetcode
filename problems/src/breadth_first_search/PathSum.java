package breadth_first_search;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSum {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private List<List<Integer>> dfsHelp(TreeNode root,int sum,List<Integer> list,int target,List<List<Integer>> lists){
        if (root == null){
            return lists;
        }

        sum = sum + root.val;
        if (root.left == null && root.right == null){
            if (target == sum){
                list.add(root.val);
                lists.add(list);
            }
        }

        List myList = new ArrayList(list);
        myList.add(root.val);
        lists = dfsHelp(root.left,sum,myList,target,lists);
        List myList2 = new ArrayList(list);
        myList2.add(root.val);
        list.containsAll(dfsHelp(root.right,sum,myList2,target,lists));
        return lists;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        return dfsHelp(root,0,new ArrayList<>(),sum,new ArrayList<>());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        TreeNode t1 = new TreeNode(11);
        TreeNode t2 = new TreeNode(13);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(1);
        root.left.left = t1;
        t1.left = t4;
        t1.right = t5;
        root.right.left = t2;
        root.right.right = t3;
        t3.left = t6;
        t3.right = t7;

        System.out.println(new PathSum().pathSum(root,22));
    }
}
