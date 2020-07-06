package tencent;

/**
 * 309. 最佳买卖股票时机含冷冻期
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
 * dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
 * dp[i][1] = max(dp[i-1][1], dp[i-2][0] - prices[i])
 * 解释：第 i 天选择 buy 的时候，要从 i-2 的状态转移，而不是 i-1 。
 */
public class MaxProfitIII {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;dp[0][1] = -prices[0]; //第0天持股，那么价格就是-prices[0]了
        //第1天不持股，要么第0天就不持股，要么就是第0天持股，然后第1天卖出
        dp[1][0] = Math.max(dp[0][0],dp[0][1]+prices[1]);
        //第一天持股，要么就是第0天就持股了，要么就是第0天不持股第1天持股
        dp[1][1] = Math.max(dp[0][1],dp[0][0]-prices[1]);

        for (int i=2;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2};
        System.out.println(new MaxProfitIII().maxProfit(prices));
    }
}