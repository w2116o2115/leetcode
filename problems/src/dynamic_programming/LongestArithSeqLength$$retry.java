package dynamic_programming;

import java.util.Arrays;

/**
 * 1027. 最长等差数列
 * 给定一个整数数组 A，返回 A 中最长等差子序列的长度。
 *
 * 回想一下，A 的子序列是列表 A[i_1], A[i_2], ..., A[i_k] 其中 0 <= i_1 < i_2 < ... < i_k <= A.length - 1。
 * 并且如果 B[i+1] - B[i]( 0 <= i < B.length - 1) 的值都相同，那么序列 B 是等差的。
 *
 * 示例 1：
 * 输入：[3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 *
 * 思路 ： 等差数列 a b c  2*b = a+c  === > a =  2b -c;
 *         dp[i][j]  i和j  以i和j为结束的等差数列的最长长度
 *         first = 2A[i] - A[j];
 *         dp[i][j] = dp[first][i]+1;
 *         需要一个数组去存储计算结果的索引
 */
public class LongestArithSeqLength$$retry {
    public int longestArithSeqLength(int[] A) {
        if (A == null || A.length ==0) return 0;
        int[] index = new int[20001];
        Arrays.fill(index,-1);

        int n = A.length;
        int[][] dp = new int[n][n];
        int max = 2;
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i],2);
            for (int j=i+1;j<n;j++){
                int first = A[i]*2 - A[j];
                if (first < 0 || index[first] == -1) continue;
                dp[i][j] = dp[index[first]][i]+1;
                max = Math.max(max,dp[i][j]);
            }
            index[A[i]] = i;
        }
        return max;
    }
}