package tencent;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        int[] right = new int[nums.length];
        right[0] = nums[nums.length-1];
        for (int i=1;i<nums.length;i++){
            left[i] = left[i-1]*nums[i];
        }
        for (int i=1;i<nums.length;i++){
            right[i] = right[i-1]*nums[nums.length-1-i];
        }
        int[] res = new int[nums.length];
        for (int i=0;i<nums.length-1;i++){
            res[i] = i==0?right[nums.length-2]:left[i-1]*right[nums.length-2-i];
        }
        res[nums.length-1] = left[nums.length-2];
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(new ProductExceptSelf().productExceptSelf(nums));
    }
}