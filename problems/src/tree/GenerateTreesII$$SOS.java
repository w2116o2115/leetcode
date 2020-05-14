package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 思路： 递归
 * 本题依旧是树的题目，并要求定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树（二叉搜索树：树当中的任何子树的左子树的节点都小于根节点，
 * 任何子树的右子树的节点都大于根节点）。根据搜索二叉树的定义，我们从1~n中取第i个数作为根节点，那么他的前i-1（从1到i-1）个数为它的左子树，
 * 后n-i（从i+1到n）个数为它的右子树，最后只需将找好的左子树，与 右子树根据排列的方式进行组合即可找出所有的情况。

 */
public class GenerateTreesII$$SOS {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generateTreeHelper(1,n);
    }

    public List<TreeNode> generateTreeHelper(int i, int j){
        List<TreeNode> res = new ArrayList<>();
        if (i>j) {
            res.add(null);
            return res;
        }
        if (i == j){
            TreeNode node = new TreeNode(i);
            res.add(node);
            return res;
        }
        for (int k = i;k<=j;k++){//找出以K为跟节点的左右子树
            List<TreeNode> left = generateTreeHelper(i,k-1);
            List<TreeNode> right = generateTreeHelper(k+1,j);
            for(TreeNode tmpR: right){
                for(TreeNode tmpL: left){
                    TreeNode tn = new TreeNode(k);
                    tn.left = tmpL;
                    tn.right = tmpR;
                    res.add(tn);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateTreesII$$SOS().generateTrees(3));
    }
}