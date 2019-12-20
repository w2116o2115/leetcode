package top100;

import java.util.Arrays;

/**
 * 4. 寻找两个有序数组的中位数
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
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] num = new int[nums1.length+nums2.length];
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i=0,j=0,index = 0;
        while (i<len1 && j<len2){
            num[index++] = nums1[i]> nums2[j]? nums2[j++]:nums1[i++];
        }
        while (i<len1){
            num[index++] = nums1[i++];
        }
        while (j<len2){
            num[index++] = nums2[j++];
        }
        return num.length%2==0?(num[num.length/2]+num[num.length/2-1])/2f:num[num.length/2];
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2};
        int[] num2 = new int[]{3,4};

        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(num1,num2));
    }
}
