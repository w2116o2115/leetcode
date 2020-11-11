package dynamic_programming;

/**
 * 213. 打家劫舍 II
 *
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [2,3,2]
 * 输出: 3
 * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * dp[i] 代表前 ii 个房子在满足条件下的能偷窃到的最高金额。
 *
 * 转移方程：
 * 设： 有 n 个房子，前 n 间能偷窃到的最高金额是 dp[n] ，前 n−1 间能偷窃到的最高金额是 dp[n-1] ，此时向这些房子后加一间房，此房间价值为 num ；
 * 加一间房间后： 由于不能抢相邻的房子，意味着抢第 n+1 间就不能抢第 n 间；那么前 n+1 间房能偷取到的最高金额 dp[n+1] 一定是以下两种情况的 较大值 ：
 * 不抢第 n+1 个房间，因此等于前 n 个房子的最高金额，即 dp[n+1] = dp[n]；
 * 抢第 n+1 个房间，此时不能抢第 n 个房间；因此等于前 n−1 个房子的最高金额加上当前房间价值，即 dp[n+1] = dp[n-1] + num ；
 *
 * 细心的我们发现： 难道在前 n 间的最高金额 dp[n] 情况下，第 n 间一定被偷了吗？假设没有被偷，那 n+1 间的最大值应该也可能是 dp[n+1] = dp[n] + num吧？
 *                 其实这种假设的情况可以被省略，这是因为：
 * 假设第 n 间没有被偷，那么此时 dp[n] = dp[n-1] ，此时 dp[n+1] = dp[n] + num = dp[n-1] + num ，即可以将 两种情况合并为一种情况 考虑；
 * 假设第 n 间被偷，那么此时 dp[n+1] = dp[n] + num 不可取 ，因为偷了第 n 间就不能偷第 n+1 间。
 * 最终的转移方程： dp[n+1] = max(dp[n],dp[n-1]+num)
 */
public class Rob {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0) {
            return 0;
        }
        if(nums.length<=2) {
            return (nums.length==2) ? Math.max(nums[0],nums[1]) : nums[0];
        }
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        //初始化两个dp数组，dp1是计算的是[1,end],dp2计算的是[0,end-1]
        dp1[0] = 0;
        dp1[1] = nums[1];
        dp2[0] = nums[0];
        dp2[1] = Math.max(nums[0],nums[1]);
        //按照【打家劫舍 I】的转移方式执行两遍
        for(int i=2;i<n;++i) {
            dp1[i] = Math.max(dp1[i-1],dp1[i-2]+nums[i]);
        }
        for(int i=2;i<n-1;++i) {
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        }
        return Math.max(dp1[n-1],dp2[n-2]);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        System.out.println(new Rob().rob(nums));
    }
}
