package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 96. 不同的二叉搜索树
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *   动态规划 : f(i)=G(i−1)∗G(n−i)
 *
 *   当以k为根节点的时候，它左面有k-1个元素，右面有n-k个元素，组成的二叉树共有C(k-1)*C(n-k)种，所以对于这个整数n来讲，
 *   所有的二叉树的个数re=C(0)*C(n-1) +C(1)*C(n-2) +....+C(k-1)*C(n-k)+...+C(n-1)*C(0)。
 */
public class NumTrees$$SOS {

    public int numTrees(int n) {
        int res = 0;
        if (n == 0 || n == 1) return 1;
        for (int k=0;k<n;k++){
            res+= numTrees(k)*numTrees(n-k-1);
        }
        return res;
    }

    public int numTrees1(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n + 1; i++)
            for(int j = 1; j < i + 1; j++)
                dp[i] += dp[j-1] * dp[i-j];

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumTrees$$SOS().numTrees(3));
    }
}