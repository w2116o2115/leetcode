package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 90. 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: [1,2,2]
 * 输出:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(0,nums,res,new Stack<>());
        return res;
    }

    private void backTrack(int index, int[] nums, List<List<Integer>> res, Stack<Integer> stack){
        res.add(new ArrayList<>(stack));

        for (int i = index;i<nums.length;i++){
            if (i>index && nums[i] == nums[i-1])
                continue;
            stack.push(nums[i]);
            backTrack(i+1,nums,res,stack);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
        System.out.println(new SubsetsWithDup().subsetsWithDup(nums));
    }
}