package array;

/**
 * 今天介绍的是LeetCode算法题中Easy级别的第109题（顺位题号是485）。给定二进制数组，找到此数组中连续1的最大数量。例如：
 *
 * 输入：[1,1,0,1,1,1]
 *
 * 输出：3
 *
 * 说明：前两位或后三位是连续的1。连续1的最大数量为3。
 *
 * 注意：
 *
 * 输入数组只包含0和1。
 *
 * 输入数组的长度是一个正整数，不会超过10,000。
 */
public class MaxConsecutiveOnes$E {
  public static void main(String[] args) {
    System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
  }

  public static int findMaxConsecutiveOnes(int[] nums) {
    int max = Integer.MIN_VALUE;
    int count = 0;
    for (int i = 0;i<nums.length;i++){
      if (nums[i] == 1){
        count++;
      }else {
        max = Math.max(max,count);
        count = 0;
      }
    }
    max = Math.max(max,count);
    return max;
  }
}
