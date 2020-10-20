package array;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例: 
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * <p>
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 * 思路：滑动窗口
 * 我们把数组中的元素不停的入队，直到总和大于等于s为止，接着记录下队列中元素的个数，然后再不停的出队，
 * 直到队列中元素的和小于s为止（如果不小于s，也要记录下队列中元素的个数，这个个数其实就是不小于s的连
 * 续子数组长度，我们要记录最小的即可）。接着再把数组中的元素添加到队列中……重复上面的操作，直到数组中的元素全部使用完为止。
 * 这里以[2,3,1,2,4,3]举例画个图来看下
 */
public class MinSubArrayLen$$retry {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s && left <= right) {
                sum -= nums[left++];
                res = Math.min(res,right-left+1);
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,2, 3};
        System.out.println(new MinSubArrayLen$$retry().minSubArrayLen(6, nums));
    }
}