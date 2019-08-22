package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
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
 * 加个map
 */
public class SubsetsII$M {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] n = {1,2,2};
    List<List<Integer>> result = new SubsetsII$M().subsets(n);
    System.out.println(result);
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(0, nums, res, new Stack<>());
    return res;

  }

  private void backtrack(int i, int[] nums, List<List<Integer>> res, Stack<Integer> tmp) {
    res.add(new ArrayList<>(tmp));
    for (int j = i; j < nums.length; j++) {
      tmp.add(nums[j]);
      backtrack(j + 1, nums, res, tmp);
      tmp.pop();
    }
  }
}
