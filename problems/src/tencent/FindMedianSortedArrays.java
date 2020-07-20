package tencent;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int [] merge  = new int[nums1.length + nums2.length];
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i=0,j=0,index = 0;
        while (i<len1 && j<len2){
            merge[index++] = nums1[i] > nums2[j] ? nums1[i++]:nums2[j++];
        }
        while (i<len1){
            merge[index++] = nums1[i++];
        }
        while (j<len2){
            merge[index++] = nums2[j++];
        }
        return merge.length%2==0?(merge[merge.length/2]+merge[merge.length/2-1])/2f:merge[merge.length/2];
    }
}