package dynamic_programming;

/**
 * 152. 乘积最大子序列
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 我们只要记录前i的最小值, 和最大值, 那么 dp[i] = max(nums[i] * pre_max, nums[i] * pre_min, nums[i]), 这里0 不需要单独考虑, 因为当相乘不管最大值和最小值,都会置0
 */
public class MaxProduct$SOS {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums[0];
        int max = nums[0];
        int min = nums[0];
        for (int i=1;i<nums.length;i++){
            int curr_max = Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            int curr_min = Math.min(Math.min(max*nums[i],min*nums[i]),nums[i]);
            res = Math.max(res,curr_max);
            max = curr_max;
            min = curr_min;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        System.out.println(new MaxProduct$SOS().maxProduct(nums));
    }
}
