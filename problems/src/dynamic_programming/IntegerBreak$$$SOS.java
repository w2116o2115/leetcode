package dynamic_programming;

/**
 * 343. 整数拆分
 *
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 思路：
 *  状态数组dp[i]表示：数字 i 拆分为至少两个正整数之和的最大乘积。为了方便计算，dp 的长度是 n + 1，值初始化为 1。
 *
 *  显然dp[2]等于 1，外层循环从 3 开始遍历，一直到 n 停止。内层循环 j 从 1 开始遍历，一直到 i 之前停止，它代表着
 *  数字 i 可以拆分成 j + (i - j)。但 j * (i - j)不一定是最大乘积，因为i-j不一定大于dp[i - j]（数字i-j拆分成整
 *  数之和的最大乘积），这里要选择最大的值作为 dp[i] 的结果。
 */
public class IntegerBreak$$$SOS {
    public int integerBreak(int n) {
        if(n <= 3) return n-1;
        int[] dp = new int[n+1];
        dp[1] = 1;dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            for(int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak$$$SOS().integerBreak(10));
    }
}
