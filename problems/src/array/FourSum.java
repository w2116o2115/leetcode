package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i=0;i<len-3;i++){
            for (int j = i+1;j<len-2;j++){
                int L = j+1;
                int R = len-1;
                while (L<R){
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    if (sum == target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[L],nums[R]));
                        while (L<R && nums[L] == nums[L+1]) L++; // 去重
                        while (L<R && nums[R] == nums[R-1]) R--; // 去重
                        L++;
                        R--;
                    }
                    else if (sum < 0) L++;
                    else if (sum > 0) R--;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2},0);
    }
}
