package array;

import java.util.Arrays;

/**
 * 最少移动次数使数组元素相等之二
 *
 * <p>You may assume the array's length is at most 10,000.
 *
 * <p>Example:
 *
 * <p>Input: [1,2,3]
 *
 * <p>Output: 2
 *
 * <p>Explanation: Only two moves are needed (remember each move increments or decrements one
 * element):
 *
 * <p>[1,2,3] => [2,2,3] => [2,2,2]
 *
 * <p>Solution: O(n log n): Sort the array and find the median of the array. Use the median of array
 * to increment/decrement other value of array. Sum up the difference and return the answer.
 * 给定非空整数数组，求使得数组中的所有元素均相等的最小移动次数，一次移动是指将某个元素加1或者减1。
 *
 * 你可以假设数组长度不超过10000。
 *
 * 解题思路：
 * 求数组各元素与中位数差的绝对值之和   长度为偶数   中位数是两个有两种情况  需要算两次
 */
public class MinimumMovesToEqualArray$M {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 2, 3};
    System.out.println(new MinimumMovesToEqualArray$M().minMoves2(A));
  }

  public int minMoves2(int[] nums) {
    if (nums.length == 1) return 0;
    else if (nums.length == 2) return Math.abs(nums[0] - nums[1]);
    Arrays.sort(nums);
    int median;
    if ((nums.length % 2) == 1) {
      median = (nums.length / 2);
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += Math.abs(nums[i] - nums[median]);
      }
      return sum;
    } else {
      median = (nums.length / 2) - 1;
      int sum = 0;
      int min;
      for (int i = 0; i < nums.length; i++) {
        sum += Math.abs(nums[i] - nums[median]);
      }
      min = sum;
      sum = 0;
      median = (nums.length / 2);
      for (int i = 0; i < nums.length; i++) {
        sum += Math.abs(nums[i] - nums[median]);
      }
      min = Math.min(min, sum);
      return min;
    }
  }
}
