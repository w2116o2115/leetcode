package binary_search;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchRotatedSortedArray$M {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {5, 4, 3, 2, 1};
    System.out.println(new SearchRotatedSortedArray$M().search(A, 4));
  }

  public int search(int[] nums, int target) {
    if (nums.length == 0) return -1;
    if (nums.length == 1) {
      return (nums[0] == target) ? 0 : -1;
    }
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = (low + high) >>> 1;
      if (nums[mid] == target) return mid;
      if ((nums[mid] <= nums[low]) && (target > nums[mid] && target <= nums[high])
          || (nums[low] <= nums[mid] && (target < nums[low] || target > nums[mid]))) low = mid + 1;
      else high = mid - 1;
    }
    return (nums[low] == target) ? low : -1;
  }
}
