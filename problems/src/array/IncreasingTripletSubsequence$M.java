package array;

/**
 * 题目大意是，给定一个无序数组，判断其中是否存在一个长度为3的递增子序列。
 *
 * 即是，如果存在下标i, j, k(0 ≤ i < j < k ≤ n-1)，使得arr[i] < arr[j] < arr[k]，返回true，否则返回false。
 * 要求满足O(n)的时间复杂度和O(1)的空间复杂度。
 *
 * 应该注意到，题目要求只要在数组中找到三个递增的元素即可，不要求这三个元素是否连续，
 * 因此，只需维护两个整数变量a, b，用来记录数组中大小递增的前2个元素，满足条件时，应该有：a < b < nums[i]。
 *
 * <p>Examples: Given [1, 2, 3, 4, 5], return true.
 *
 * <p>Given [5, 4, 3, 2, 1], return false.
 */
public class IncreasingTripletSubsequence$M {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {5, 4, 3, 2, 1};
    System.out.println(new IncreasingTripletSubsequence$M().increasingTriplet(A));
  }

  public boolean increasingTriplet(int[] nums) {
    int a=Integer.MIN_VALUE;int b = Integer.MIN_VALUE;
    a = nums[0];b = nums[1];
    if (a > b) return false;
    for (int i=2;i<nums.length;i++){
      if (a < b || b < nums[i])
        return true;
      a = nums[i-1];
      b = nums[i];
    }
    return false;
  }
}
