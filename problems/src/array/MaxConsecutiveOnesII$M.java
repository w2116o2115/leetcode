package array;

/**
 * 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 *
 * 示例 1：
 *
 * 输入：[1,0,1,1,0]
 * 输出：4
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 *      当翻转以后，最大连续 1 的个数为 4。
 *  
 *
 * 注：
 *
 * 输入数组只包含 0 和 1.
 * 输入数组的长度为正整数，且不超过 10,000
 */
public class MaxConsecutiveOnesII$M {
  public static void main(String[] args) {
    System.out.println(findMaxConsecutiveOnes(new int[]{1,0,1,1,0}));
  }

  public static int findMaxConsecutiveOnes(int[] nums) {
    int res = 0, cur = 0, cnt = 0;//cnt连续1的个数   cur记录第一次遇见0的时候连续1的个数
    for (int num : nums) {
      ++cnt;
      if (num == 0) {
        cur = cnt;
        cnt = 0;
      }
      res = Math.max(res, cnt + cur);
    }
    return res;
  }
}
