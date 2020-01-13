package leetcode.top250;

/**
 * 81. 搜索旋转排序数组 II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */
public class Search {
    public boolean search(int[] nums, int target) {
        int mid = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i] < nums[i-1])
                mid = i;
        }

        return check(0,mid-1,target,nums) || check(mid,nums.length-1,target,nums);
    }

    private boolean check(int left, int right, int target, int[] nums) {
        if (left > right)
            return false;
        int mid = (left + right) >> 1;
        boolean left_check = false;
        boolean right_check = false;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] > target) {
            left_check = check(left, mid - 1, target, nums);
        } else if (nums[mid] < target) {
            right_check = check(mid + 1, right, target, nums);
        }
        return left_check || right_check;
    }
}
