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
 */
public class SearchRange {
    private int[] search(int[] nums, int target,int l,int r,int[] result){
        if (l == r){
            if (nums[l] == target){
                result[0] = result[0] == -1?l:Math.min(l,result[0]);
                result[1] = Math.max(l,result[1]);
            }
            return result;
        }
        int mid = (l+r) >>> 1;
        if (nums[mid] == target){
            result[0] = result[0] == -1?mid:Math.min(mid,result[0]);
            result[1] = Math.max(mid,result[1]);
        }
        if (nums[mid] >= target){
            result = search(nums,target,l,mid-1,result);
        }
        if (nums[mid+1] <= target){
            result = search(nums,target,mid+1,r,result);
        }
        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        return search(nums,target,0,nums.length-1,new int[]{});
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int[] a = new SearchRange().search(nums,8,0,nums.length-1,new int[]{-1,-1});
        System.out.println(1);
    }
}
