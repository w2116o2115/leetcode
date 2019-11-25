package array;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        int len = nums.length;
        for (int i=0;i<len;i++){
            int L = i+1;
            int R = len-1;
            while (L<R){
                int sum = nums[L] + nums[R] +  nums[i];
                if (Math.abs(target - sum) < Math.abs(target - result))
                    result = sum;
                if (sum > target) {
                    R--;
                }else {
                    L++;
                }
            }
        }
        return result;
    }
}
