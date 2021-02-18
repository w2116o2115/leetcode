package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    public static List<List<Integer>> result = new ArrayList<>();

    /**
     * Main method
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int[] candidates = {2, 3, 6, 7};

        List<List<Integer>> result = new CombinationSum().combinationSum(candidates, 7);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        doNext(candidates.length, new Stack<>(), candidates, target, sum, 0);
        return result;
    }

    private void doNext(int len, Stack<Integer> stack, int[] candidates, int target, int sum, int index) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = index; i < len; i++) {
            stack.add(candidates[i]);
            doNext(len, stack, candidates, target, sum + candidates[i], i);
            stack.pop();
        }
    }
}
