package dynamic_programming;

/**
 * 312. 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 * 示例 1：
    输入：nums = [3,1,5,8]
    输出：167
    解释：
    nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
    coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167

    思路 : 区间动态规划
    dp[i][j] 扎破 第i到j个气球所能得到的最大值
 */
public class MaxCoins$$retry {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int len = n+2;
        int[] a = new int[len];
        System.arraycopy(nums,0,a,1,n);
        a[0] = 1;a[len-1] = 1;
        int[][] dp = new int[len][len];

        for (int gap=2;gap<len;gap++){
            for (int left = 0;left<len-gap;left++){
                int right = left+gap;
                int cur = 0;
                for (int i = left+1;i<right;i++){
                    cur = Math.max(cur,dp[left][i] + dp[i][right] + a[i]*a[left]*a[right]);
                }
                dp[left][right] = cur;
            }
        }
        return dp[0][len-1];
    }
}
