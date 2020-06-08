package depth_first_search;

import java.util.Stack;

/**
 * 494. 目标和
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，
 * 你都可以从 + 或 -中选择一个符号添加在前面。
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
 * +1+1+1+1-1 = 3findBottomLeftValue
 *
 * 一共有5种方法让最终目标和为3。
 */
public class FindTargetSumWays {
    int res;

    public int findTargetSumWays(int[] nums, int S) {
        res = 0;
        dfs(S,nums,0);
        return res;
    }

    private void dfs(int target,int[] nums,int start){
        if (start == nums.length){
            if (0 == target)
                res++;
            return;
        }

        dfs(target+nums[start],nums,start+1);
        dfs(target-nums[start],nums,start+1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(new FindTargetSumWays().findTargetSumWays(nums,3));
    }
}