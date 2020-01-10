package leetcode.top250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        bankTrack(res,visited,nums,new Stack<>());
        return res;
    }

    private void bankTrack(List<List<Integer>> res, boolean[] visited, int[] nums, Stack<Integer> stack){
        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (visited[i]) continue;
            //i-1和i的值相等，且i-1没被用过（之后可能会被用就产生重复）flag【i-1】=false是取相等的数中最左边的那个数当ll的第一个数，
            // 而flag【i-1】=true就是取相等的数中最右边的那个数当ll的第一个数，也就是说分别取第一行和第二行。
            if(i>0 && nums[i-1]==nums[i] && !visited[i-1]) {
                continue;
            }
            visited[i] = true;
            stack.push(nums[i]);
            bankTrack(res,visited,nums,stack);
            stack.pop();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{3,3,0,3}));
    }
}
