package tencent;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

   设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

   注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

     dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
     dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
     = max(dp[i-1][k][1], dp[i-1][k][0] - prices[i])

     我们发现数组中的 k 已经不会改变了，也就是说不需要记录 k 这个状态了：
     dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;dp[0][1] = -prices[0];
        for (int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,4,5};
        System.out.println(new MaxProfit().maxProfit(prices));
    }
}
