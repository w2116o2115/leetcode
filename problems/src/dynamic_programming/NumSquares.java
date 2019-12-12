package dynamic_programming;

/**
 * 279. 完全平方数
 *
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 示例 1:
 *
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 *
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 *
 * 题目的本质是01完全背包问题，和硬币找零钱是一样的
 *
 * 【笔记】动态规划。dp[i]表示数字i由多少个完全平方数组成。
 *  状态转移公式如下：dp[i] = min(dp[i], dp[i-k*k]+1);
 */
public class NumSquares {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for (int i=1;i<=n;i++){
            dp[i] = i;//第几个数  可以由几个1的平方组成
            for (int j=1;i - j * j >= 0;j++){//增加一个平方
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(12));
    }
}
