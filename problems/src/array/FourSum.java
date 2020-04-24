package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int first=0;first<nums.length;first++){
            if (first > 0 && nums[first] == nums[first-1]) continue;
            for (int second = first+1;second < nums.length;second++) {
                if (second>first+1 && nums[second] == nums[second-1]) continue;
                int L = second + 1;
                int R = nums.length - 1;
                while (L < R) {
                    int sum = nums[first] + nums[second] + nums[L] + nums[R];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[first], nums[second], nums[L], nums[R]));
                        while (L<R && nums[L]==nums[L+1]) L++;
                        while (L<R && nums[R]==nums[R-1]) R--;
                        L++;
                        R--;
                    } else if (sum > target) {
                        R--;
                    } else if (sum < target) {
                        L++;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{-1,-5,-5,-3,2,5,0,4},-7));
    }
}
