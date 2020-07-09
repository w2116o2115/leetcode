package tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 46. 全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        int[] visited = new int[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        backTrack(visited,res,nums,new Stack<>());
        return res;
    }

    private void backTrack(int[] visited, List<List<Integer>> res, int[] nums, Stack<Integer> stack){
        if (stack.size() == nums.length){
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (visited[i] == 1)
                continue;
            visited[i] = 1;
            stack.add(nums[i]);
            backTrack(visited,res,nums,stack);
            visited[i] = 0;
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new Permute().permute(nums));
    }
}