package dynamic_programming.zeroOrOneknapsack;

/**
 * 416. 分割等和子集
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 *
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 *
 * 输入: [1, 5, 11, 5]
 * 输出: true
 *
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 *
 * dp[i][j]：表示从数组的 [0, i] 这个子区间内挑选一些正整数，每个数只能用一次，使得这些数的和等于 j。
 *
 * 根据我们学习的 0-1 背包问题的状态转移推导过程，新来一个数，例如是 nums[i]，根据这个数可能选择也可能不被选择：
 *
 * 如果不选择 nums[i]，在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
 * 如果选择 nums[i]，在 [0, i - 1] 这个子区间内就得找到一部分元素，使得它们的和为 j - nums[i] ，我既然这样写出来了，
 * 你就应该知道，这里讨论的前提条件是 nums[i] <= j。
 * 以上二者成立一条都行。于是得到状态转移方程是：
 *
 * dp[i][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]], (nums[i] <= j)
 *
 */
public class CanPartition$SOS {
    public boolean canPartition(int[] nums) {
        int count = 0;
        for (int num:nums){
            count+=num;
        }
        if ((count & 1) == 1) return false;
        int target = count/2;
        boolean[][] dp = new boolean[nums.length][target+1];

        for (int i=1;i<target+1;i++){
            dp[0][i] = true;//都不选当前数组
        }

        for (int i=0;i<nums.length;i++){
            for (int j = 0;j<=target;j++){
                if (j>=nums[i]){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];//选当前数字 或者 不选当前数字
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
