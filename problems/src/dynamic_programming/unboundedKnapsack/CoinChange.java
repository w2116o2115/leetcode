package dynamic_programming.unboundedKnapsack;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例 1:
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * 示例 2:
 *
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 思路：这道题是完全背包问题的变种，采用动态规划维护一个二维数组dp，
 * dp[i][j]表示从第一个元素到第i个元素累计总金额为j时的最少硬币数量，递推公式为：
 * dp[i][j] = min(dp[i - 1][j], dp[i][j - coins[i]]+1);
 *
 * dp[i] 表示 凑够i需要的最小货币数
 * dp[i] = min(dp[i-1],dp[i-coin]+1)  对所有的价值进行遍历，每一个价值去遍历所有的货币
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin:coins){
            for (int i=coin;i<=amount;i++){
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{1,2,5},11));
    }
}
