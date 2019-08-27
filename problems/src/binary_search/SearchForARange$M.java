package binary_search;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class SearchForARange$M {
  public static void main(String[] args) throws Exception {
    int[] test = {
      5, 7, 7, 8, 8, 10, 10, 10, 10, 18, 19, 20, 21, 21, 21, 21, 22, 23, 28, 28, 90, 101, 101, 101,
      200, 200, 200, 200, 200, 200
    };
    int[] result = new SearchForARange$M().searchRange(test, 200);
    for (int i : result) System.out.print(i + " ");
  }

  public int[] searchRange(int[] nums, int target) {
    int low = findIndex(nums, target, true);
    int high = findIndex(nums, target, false);
    int[] result = new int[2];
    result[0] = low;
    result[1] = high;
    return result;
  }

  /**
   * Find index
   *
   * @param nums nums array
   * @param target target
   * @param isLowerIndex true if target is to find lower index, false otherwise
   * @return index
   */
  private int findIndex(int[] nums, int target, boolean isLowerIndex) {
    int result = -1;
    int s = 0, e = nums.length - 1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if (nums[m] == target) {
        result = m;
        if (isLowerIndex)
          e = m - 1; // if searching for the lower index then search the lower bound,
        // else search the upper bound
        else s = m + 1;
      } else if (nums[m] < target) {
        s = m + 1;
      } else e = m - 1;
    }
    return result;
  }
}
