package dynamic_programming.zeroOrOneknapsack;

/**
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。
 * 对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 *
 *      * sum(P) 前面符号为+的集合；sum(N) 前面符号为减号的集合
 *      * 所以题目可以转化为
 *      * sum(P) - sum(N) = target
 *      * => sum(nums) + sum(P) - sum(N) = target + sum(nums)
 *      * => 2 * sum(P) = target + sum(nums)
 *      * => sum(P) = (target + sum(nums)) / 2
 *      * 因此题目转化为01背包，也就是能组合成容量为sum(P)的方式有多少种
 *
 * dp的第x项，代表组合成数字x有多少方法。比如说,dp[0] = 1，代表组合成0只有1中方法，即什么也不取。比如说dp[5] = 3 ，代表使总和加到5总共有三种方法。
 * 所以最后返回的就是dp[P]，代表组合成P的方法有多少种
 */

public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int w = (sum + S) / 2;
        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = w; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[w];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(new FindTargetSumWays().findTargetSumWays(nums,3));
    }
}
