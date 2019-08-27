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
            5,7,7,8,8,10
    };
    int[] result = new SearchForARange$M().searchRange(test, 8);
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
    int left = 0,right = nums.length - 1;
    while (left <= right){
      int mid = (left + right) >>> 1;
      if (nums[mid] == target){
        result = mid;
        if (!isLowerIndex) {
          left = mid + 1;
        }else {
          right = mid - 1;
        }
      }else {
        if (nums[mid] > target){
          right = mid - 1;
        }else {
          left = mid + 1;
        }
      }
    }
    return result;
  }
}
