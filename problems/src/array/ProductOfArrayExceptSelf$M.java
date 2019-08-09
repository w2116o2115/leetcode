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
 */
public class ProductOfArrayExceptSelf$M {
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4};
    int[] result = new ProductOfArrayExceptSelf$M().productExceptSelf(nums);
    for (int r : result) System.out.print(r + " ");
  }

  public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0, temp = 1, l = nums.length; i < l; i++) {
      result[i] = temp;
      temp *= nums[i];
    }
    for (int i = nums.length - 1, temp = 1; i >= 0; i--) {
      result[i] = result[i] * temp;
      temp *= nums[i];
    }
    return result;
  }
}
