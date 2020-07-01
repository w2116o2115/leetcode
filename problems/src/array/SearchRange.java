package array;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 思路： 二分法查找 ，找到以后  比较 找到最大 以及 最小的位置
 */
public class SearchRange {
    private int[] search(int[] nums, int target,int l,int r,int[] result){
        if (l>r)
            return result;
        int mid = l+r >> 1;
        if (nums[mid] == target){
            result[0] = result[0] == -1?mid:Math.min(result[0],mid);
            result[1] = result[1] == -1?mid:Math.max(result[1],mid);
            search(nums,target,l,mid-1,result);
            search(nums,target,mid+1,r,result);
        }else if (nums[mid] > target){
            search(nums,target,l,mid-1,result);
        }else {
            search(nums,target,mid+1,r,result);
        }
        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        return search(nums,target,0,nums.length-1,new int[]{-1,-1});
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] a = new SearchRange().search(nums,8,0,nums.length-1,new int[]{-1,-1});
        System.out.println(1);
    }
}
