package array;

/**
 * Created by gouthamvidyapradhan on 29/07/2017. Given two sorted integer arrays nums1 and nums2,
 * merge nums2 into nums1 as one sorted array.
 *
 * <p>Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to
 * hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m
 * and n respectively.
 * 给定两个已排序整数数组nums1和nums2，合并nums2到nums1中作为一个已排序数组
 *
 给定两个排序的整数数组nums1和nums2，将nums2中的元素合并到nums1中，
 并且作为一个排序的数组。在nums1和nums2中初始化的元素个数分别为m和n。
 假设nums1有足够的空间（大于或等于m + n）来保存nums2中的其他元素。例如：

 输入：nums1 = [1,2,3,0,0,0]，m = 3，nums2 = [2,5,6]，n = 3
 输出：[1,2,2,3,5,6]
 */
public class MergeSortedArray$E {
  public static void main(String[] args) throws Exception {
    int[] A = {2,5,6,0,0,0};
    int[] B = {1,2,3};
    new MergeSortedArray$E().merge(A, 3, B, 3);
    for (int i : A) System.out.println(i);
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m + n - 1,a = m - 1,b = n - 1;
    while (i >= 0 && a >= 0)
      nums1[i--] = nums1[a] > nums2[b] ? nums1[a--]:nums2[b--];
    while (b >= 0)
      nums1[i--] = nums2[b--];
  }
}
