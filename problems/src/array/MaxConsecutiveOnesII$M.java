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
    //
  }

  public int findMaxConsecutiveOnes(int[] nums) {
    int[] L = new int[nums.length];
    int[] R = new int[nums.length];
    boolean flag = false;
    int count = 0;
    int max = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] == 1) {
        if (!flag) {
          flag = true;
        }
        count++;
        L[j] = count;
      } else {
        count = 0;
        flag = false;
        L[j] = count;
      }
      max = Math.max(max, count);
    }

    flag = false;
    count = 0;
    for (int j = nums.length - 1; j >= 0; j--) {
      if (nums[j] == 1) {
        if (!flag) {
          flag = true;
        }
        count++;
        R[j] = count;
      } else {
        count = 0;
        flag = false;
        R[j] = count;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        int l = i == 0 ? 0 : L[i - 1];
        int r = i == nums.length - 1 ? 0 : R[i + 1];
        max = Math.max(max, l + r + 1);
      }
    }
    return max;
  }
}
