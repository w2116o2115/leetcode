package array;

/**
 * 除自身以外数组的乘积
 *
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 思路
 * 我们想，对于某一个数字，如果我们知道其前面所有数字的乘积，同时也知道后面所有的数乘积，那么二者相乘就是我们要的结果，
 * 所以我们只要分别创建出这两个数组即可，分别从数组的两个方向遍历就可以分别创建出乘积累积数组
 *
 */
public class ProductOfArrayExceptSelf$M {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    int[] result = new ProductOfArrayExceptSelf$M().productExceptSelf(nums);
    for (int r : result) System.out.print(r + " ");
  }

  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    for (int i=0,temp = 1;i<nums.length;i++){
      result[i] = temp;
      temp = nums[i] * temp;
    }
    for (int j=nums.length-1,temp = 1;j>=0;j--){
      result[j] = result[j]*temp;
      temp *= nums[j];
    }
    return result;
  }
}
