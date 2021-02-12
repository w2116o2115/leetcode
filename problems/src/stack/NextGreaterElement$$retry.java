package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。

 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 输出: [-1,3,-1]

 思路 ： 单调栈
 */
public class NextGreaterElement$$retry {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n = nums2.length;
            Deque<Integer> stack = new ArrayDeque<>();
            Map<Integer,Integer> map = new HashMap<>();
            int[] res = new int[nums1.length];

            for (int i = n-1;i >= 0;i--){
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                    stack.pop();
                }
                map.put(nums2[i],stack.isEmpty()?-1:stack.peek());
            }

            for (int i=0;i<nums1.length;i++){
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
}
