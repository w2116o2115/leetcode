package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 325 : 和等于 k 的最长子数组长度
 * 给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。
 * 注意:
 *  nums 数组的总和是一定在 32 位有符号整数范围之内的。
 *
 * 示例 1:
 * 输入: nums = [1, -1, 5, -2, 3], k = 3
 * 输出: 4
 * 解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
 * 示例 2:
 * 输入: nums = [-2, -1, 2, 1], k = 1
 * 输出: 2
 * 解释: 子数组 [-1, 2] 和等于 1，且长度最长。
 *
 * 思路 ： 前缀和（prefix sum）是算法题中比较实用的一种技巧
 */
public class MaxSubArrayLen$$retry {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        int res = 0;
        int[] sums = new int[nums.length+1];
        sums[0] = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for (int i=1;i<nums.length;i++){
            sums[i] = sums[i-1] + nums[i-1];
            if (!map.containsKey(sums[i])){
                map.put(sums[i],i);
            }
        }
        for (int i = sums.length - 1; i > res; i--) {
            if (map.containsKey(sums[i] - k)) {
                res = Math.max(res, i - map.get(sums[i] - k));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, -1, 5, -2, 3};
        System.out.println(new MaxSubArrayLen$$retry().maxSubArrayLen(nums,3));
    }
}