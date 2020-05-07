package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组，返回数组区间范围的汇总。
 *
 * 示例 1:
 *
 * 输入: [0,1,2,4,5,7]
 * 输出: ["0->2","4->5","7"]
 * 解释: 0,1,2 可组成一个连续的区间; 4,5 可组成一个连续的区间。
 * 示例 2:
 *
 * 输入: [0,2,3,4,6,8,9]
 * 输出: ["0","2->4","6","8->9"]
 * 解释: 2,3,4 可组成一个连续的区间; 8,9 可组成一个连续的区间。
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        int left = 0;
        int right = 0;
        while (right < nums.length){
            right++;
            if (right == nums.length || nums[right] != nums[right-1] +1){
                if (nums[left] == nums[right -1]){
                    res.add(nums[left]+"");
                }else {
                    res.add(nums[left]+"->"+nums[right-1]);
                }
                left = right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,2,3,4,6,8,9};
        System.out.println(new SummaryRanges().summaryRanges(nums));
    }
}