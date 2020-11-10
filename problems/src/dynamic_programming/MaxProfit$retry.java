package dynamic_programming;

/**
 * 309. 最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * 看了评论区和题解区的大佬题解，慢慢就懂了点了。
 *
 * 可以说是简单dp+状态机。
 *
 * 两种状态：
 *
 * 持有股票
 * 不持有股票
 * 一个dp数组对应一种状态，也就是用hold_dp数组记录当天持有股票的最大利润，用unhold_dp数组记录当天不持有股票的最大利润。
 *
 * 持有股票状态：
 *
 * 昨天持有，今天继续持有，对应就是hold_dp[i] = hold_dp[i-1]
 * 前天卖掉了，今天买回来，对应就是hold_dp[i] = unhold_dp[i-2] - prices[i]
 * 不持有股票状态：
 *
 * 昨天持有，今天卖掉了，对应就是unhold_dp[i] = hold_dp[i-1] + prices[i]
 * 昨天不持有，今天继续不持有unhold_dp[i] = unhold_dp[i-1]
 *
 */
public class MaxProfit$retry {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int[] hold_dp = new int[n];//持有股票的状态机
        int[] unhold_dp = new int[n];//不持有股票的状态机
        hold_dp[0] = -prices[0];
        hold_dp[1] = Math.max(hold_dp[0], -prices[1]);
        unhold_dp[0] = 0;
        unhold_dp[1] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < n; i++) {
            hold_dp[i] = Math.max(unhold_dp[i-2] - prices[i], hold_dp[i-1]);
            unhold_dp[i] = Math.max(hold_dp[i-1] + prices[i], unhold_dp[i-1]);
        }
        return Math.max(hold_dp[n-1], unhold_dp[n-1]);
    }
}
