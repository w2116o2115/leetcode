package depth_first_search;

import java.util.*;

/**
 * 491. 递增子序列
 *
 * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
 *
 * 示例:
 *
 * 输入: [4, 6, 7, 7]
 * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 * 说明:
 *
 * 给定数组的长度不会超过15。
 * 数组中的整数范围是 [-100,100]。
 * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
 *
 *
 * 左子树是选，右子树是不选，相当于，也可以前序、中序、后序的不同写法。程序实现上，需要用一个栈，元素入栈遍历左子树，（最近入栈的那个）元素出栈，遍历右子树。
 *
 *
 * 通过dfs的方法找到第i位数右边所有比它大的数，压并且压到sbuseq中，当subseq的长度大于1的时候就把它压到ans中。这样就能找到所有递增的子序列， 但是可能会出现重复的情况；
 */
public class FindSubsequences {
    /**
     * DFS回溯问题
     * List去重会超时，直接用Set解决
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        Set<List<Integer>> ans = new HashSet<>();
        dfs(ans, new Stack<>(), nums, 0);
        return new ArrayList<>(ans);
    }

    private void dfs(Set<List<Integer>> ans, Stack<Integer> stack, int[] nums, int start) {
        List<Integer> tm = new ArrayList<>(stack);
        if (tm.size() >= 2)
            ans.add(tm);
        for (int i = start; i < nums.length; i++) {
            if (!stack.isEmpty() && stack.peek() > nums[i])//如果加入nums[i],会导致temp里面无序,所以抛弃nums[i]
                continue;
            stack.add(nums[i]);
            dfs(ans, stack, nums, i + 1);
            stack.pop();//弹出已经元素
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindSubsequences().findSubsequences(new int[]{1,2,3,4,5,6,7,8,9,10,1,1,1,1,1}).toString());
    }
}
