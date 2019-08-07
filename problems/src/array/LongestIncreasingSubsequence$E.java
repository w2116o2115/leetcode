package array;

/**
 * Created by gouthamvidyapradhan on 03/12/2017.
 *
 * <p>Given an unsorted array of integers, find the length of longest continuous increasing
 * subsequence (subarray).
 *
 * <p>Example 1: Input: [1,3,5,4,7] Output: 3 Explanation: The longest continuous increasing
 * subsequence is [1,3,5], its length is 3. Even though [1,3,5,7] is also an increasing subsequence,
 * it's not a continuous one where 5 and 7 are separated by 4. Example 2: Input: [2,2,2,2,2] Output:
 * 1 Explanation: The longest continuous increasing subsequence is [2], its length is 1. Note:
 * Length of the array will not exceed 10,000.
 *
 * 给定未排序的整数数组，找到最长连续增加子序列的长度。例如：
 *
 * 输入：[1,3,5,4,7]
 * 输出：3
 * 说明：最长的连续增加子序列为[1,3,5]，其长度为3，即使[1,3,5,7]也是一个增加的子序列，它不是一个连续的，其中5和7被4分开。
 */
public class LongestIncreasingSubsequence$E {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 3, 5, 4, 7};
    System.out.println(new LongestIncreasingSubsequence$E().findLengthOfLCIS(A));
  }

  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;
    int max = 0;int count = 0;
    for (int i=0;i<nums.length;i++){
      if (i == 0 || nums[i] > nums[i-1]){
        count++;
        max = Math.max(max,count);
      }else {
        count = 0;
      }
    }
    return max;
  }
}
