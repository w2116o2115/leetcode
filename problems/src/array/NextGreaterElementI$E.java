package array;

import java.util.Arrays;

/**
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *  输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 *  输出: [-1,3,-1]
 *  解释:
 *  对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *  对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *  对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 *
 *
 *  暴力解法。使用两层循环，先找到nums1的元素在nums2中的对应元素，然后从nums2中找到的元素的下一位往右开始判断，
 *  找到比当前元素大的元素，找得到就将其作为结果数组的元素添加进去，否则就将-1添加进结果数组。
 *
 */
public class NextGreaterElementI$E {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {2,4};
    int[] B = {1,2,3,4};
    int[] result = new NextGreaterElementI$E().nextGreaterElement(A, B);
    System.out.println(Arrays.toString(result));
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    int[] result = new int[nums1.length];
    for (int i=0;i<nums1.length;i++){
      for (int j=0;j<nums2.length;j++) {
        if (nums1[i] == nums2[j] && j+1< nums2.length && nums1[i] < nums2[j+1]) {
          result[i] = nums2[j+1];
          break;
        }
        result[i] = -1;
      }
    }
    return result;
  }
}
