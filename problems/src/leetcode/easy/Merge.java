package leetcode.easy;

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 思路  从大往小归并  从左 》》 右
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //先归并大的，这样一遍扫面即可。
        for(int k = m+n-1,i = m-1,j = n-1;k >= 0;k--){
            if(i < 0) {
                nums1[k] = nums2[j--];
                continue;
            }
            if(j < 0) {
                nums1[k] = nums1[i--];
                continue;
            }

            if(nums1[i] >= nums2[j])
                nums1[k] = nums1[i--];
            else
                nums1[k] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new  int[]{1,2,3,0,0,0};
        int[] nums2 = new  int[]{2,5,6};
        new Merge().merge(nums1,3,nums2,3);
    }
}
