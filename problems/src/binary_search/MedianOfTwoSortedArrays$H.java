package binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 */
public class MedianOfTwoSortedArrays$H {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 2, 5, 8, 44, 45, 45};
    int[] B = {1, 2, 3, 4, 5, 6, 7, 23, 23, 23, 33, 44, 45, 45, 56, 77, 5555};
    System.out.println(new MedianOfTwoSortedArrays$H().findMedianSortedArrays(A, B));
  }

  /**
   * Find median
   *
   * @param nums1 array one
   * @param nums2 array two
   * @return
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length)
      return findMedianSortedArrays(nums2, nums1); // ensure always nums1 is the shortest array
    int T = nums1.length + nums2.length, low = -1, high = -1;
    int median = (T - 1) / 2;
    boolean isOdd = false;
    if ((T % 2) != 0) isOdd = true;

    int s = 0, e = nums1.length - 1;
    while (s <= e) {
      int m = s + (e - s) / 2;
      if ((median - m - 1) < 0 || nums1[m] >= nums2[median - m - 1]) {
        e = m - 1;
        low = m;
        high = median - m;
      } else s = m + 1;
    }

    if (low == -1) {
      if (isOdd) return nums2[median - nums1.length];
      else return (double) (nums2[median - nums1.length] + nums2[median - nums1.length + 1]) / 2.0D;
    } else {
      if (isOdd) return nums1[low] < nums2[high] ? nums1[low] : nums2[high];
      else {
        // Always sorts maximum of 4 elements hence works in O(1)
        List<Integer> list = new ArrayList<>();
        list.add(nums1[low]);
        if (low + 1 < nums1.length) list.add(nums1[low + 1]);
        list.add(nums2[high]);
        if (high + 1 < nums2.length) list.add(nums2[high + 1]);
        Collections.sort(list);
        return (double) (list.get(0) + list.get(1)) / 2.0;
      }
    }
  }
}
