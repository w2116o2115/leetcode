package array;

import java.util.Arrays;

/**
 * 在给定的整数数组中，总有一个最大的元素。查找数组中的最大元素是否至少是数组中每个其他数字的两倍。如果是，则返回最大元素的索引，否则返回-1。例如：
 *
 * 输入：nums = [3,6,1,0]
 *
 * 输出：1
 *
 * 说明：6是最大的整数，对于数组x中的每个其他数字，6是x的两倍多。 值6的索引是1，所以我们返回1。
 *
 *
 * 输入：nums = [1,2,3,4]
 *
 * 输出：-1
 *
 * 说明：4至少不是3的值的两倍，所以我们返回-1。
 *
 * 注意：
 *
 * nums的长度在[1,50]范围内。
 *
 * 每个nums [i]将是[0,99]范围内的整数。
 *
 *
 * 题目的要求是返回最大数的索引，所以需要先将最大数找出来，并记录下其索引。然后在次遍历数组中的元素，
 * 将最大数之外的其他数都乘以2和最大数比较(在此处我是使用位移处理)，如果大于就返回-1，如果其他元素都满足条件，就返回之前记录的最大数的索引。
 */
public class LargestNumberAtLeastTwice$E {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(dominantIndex(new int[]{3,6,1,0}));
  }

  public static int dominantIndex(int[] nums) {
    int max = 0,maxNum = Integer.MIN_VALUE;
    int[] doubleNum = new int[nums.length];
    for (int i = 0;i<nums.length;i++){
      doubleNum[i] = 2*nums[i];
      if (maxNum < nums[i]){
        max = i;
        maxNum = nums[i];
      }
    }
    for (int num : doubleNum){
      if (num/2 == maxNum) continue;
      if (num > maxNum)
        return -1;
    }
    return max;
  }
}
