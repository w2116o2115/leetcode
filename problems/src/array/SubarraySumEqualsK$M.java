package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 这道题给了我们一个数组，让我们求和为k的连续子数组的个数
 * 题目中提醒我们必须要在O(n)的时间复杂度完成
 *
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 *
 * 最直观的想法是遍历数组并依次加当前位置的数字，同时用数组sum记录下当前位置之前所有数字的相加和，
 * 这样下标[i, j)之间的数字之和就可以用sum[j]-sum[i]来计算，然后通过双层循环，遍历所有情况来统计满足条件的子数组个数。
 *
 * sum 表示从数组开始到当前位置的数字之和 , 用map存储 sum 出现的次数
 * sum[j] - sum[k] = k  ===> sum[i] = sum[j] - k
 * 以 sum[i] 作为k 进行存储 出现一个就是 累加一次
 */
public class SubarraySumEqualsK$M {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 2, 1, -2, 3, -1, -1};
    System.out.println(new SubarraySumEqualsK$M().subarraySum(A, 2));
  }

  public int subarraySum(int[] nums, int k) {
    Map<Integer, Integer> preSum = new HashMap<>();
    int sum = 0;
    int result = 0;
    preSum.put(0, 1);
    for (int num : nums) {
      sum += num;
      if (preSum.containsKey(sum - k)) {
        result += preSum.get(sum - k);
      }
      preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
    }
    return result;
  }
}
