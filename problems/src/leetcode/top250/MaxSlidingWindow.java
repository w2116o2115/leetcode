package leetcode.top250;

/**
 * 239. 滑动窗口最大值
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] res = new int[nums.length-k+1];
//        if (nums.length == 0 || k == 0) return new int[]{};
//        int i = 0;
//        int left = 0;
//        int max = Integer.MIN_VALUE;
//        for (int right=0;right<nums.length;){
//            if ((right - left) < k-1){
//                right ++;
//            }else if ((right - left) == k-1) {
//                if (right == nums.length) break;
//                max = getMax(left,right,nums);
//                if (i<res.length) res[i++] = max;
//                right ++;
//                left ++;
//            }
//        }
//        return res;
        if (nums.length < 2) {
            return nums;
        }
        int[] result = new int[nums.length - k + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
            }
            if (i > k - 1 && nums[i] < max && max == nums[i - k]) {
                max = Integer.MIN_VALUE;
                for (int j = i - k + 1; j <= i; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                    }
                }
            }
            if (i >= k - 1) {
                result[i - k + 1] = max;
            }
        }
        return result;
    }

    private int getMax(int l,int r,int[] nums){
        int max = Integer.MIN_VALUE;
        for (int i=l;i<=r;i++){
            max = Math.max(max,nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] res = new MaxSlidingWindow().maxSlidingWindow(new int[]{1,3,-1},3);
        System.out.println(1);
    }
}
