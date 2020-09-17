package leetcode.top250;

import java.util.ArrayList;
import java.util.LinkedList;
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
 * 思路：
 * 使用分治+递归的方法建树，[1,n]中取k(1<=k<=n)为根节点，则他的左子树必定为[1,k-1]，
 * 右子树为[k+1,n]，所以递归调用建树的方法，最后把他所有的左右子树整合在一起
 */
public class GenerateTrees$$retry {
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
        //i>j返回一个空的子树
        if(i > j) {
            res.add(null);
            return res;
        }
        //i==j返回一个结点的子树
        if(i == j){
            res.add(new TreeNode(i));
            return res;
        }
        //分治+递归建树
        for(int k = i; k <= j; k++){
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
}
