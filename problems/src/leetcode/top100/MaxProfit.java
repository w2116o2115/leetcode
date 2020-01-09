package leetcode.top100;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2019/12/23 16:57
 */
public class MaxProfit {
//    public int maxProfit(int[] prices){
//        int[] dp = new int[prices.length];
//        dp[0] = 0;
//        int res = Integer.MIN_VALUE;
//        for (int i=1;i<prices.length;i++){
//            for (int j=0;j<i;j++){
//                dp[i] = Math.max(dp[0],prices[i]-prices[j]);
//                res = Math.max(dp[i],res);
//            }
//        }
//        return res;
//    }

    public int maxProfit(int[] prices){
        int res = Integer.MIN_VALUE;
        int minPrice = prices[0];
        for (int i=1;i<prices.length;i++){
            res = Math.max(res,prices[i] - minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(new MaxProfit().maxProfit(prices));
    }
}
