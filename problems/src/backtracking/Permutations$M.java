package backtracking;

import java.util.*;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
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
public class Permutations$M {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] nums = {1, 2, 3};
    List<List<Integer>> result = new Permutations$M().permute(nums);
    System.out.println(1);
  }

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    for (int num : nums){
      list.add(num);
    }
    nextPermutation(list, result , new Stack<>());
    return result;
  }

  private void nextPermutation(List<Integer> nums, List<List<Integer>> result,Stack<Integer> stack) {
    if (nums == null || nums.size() == 0) result.add(new ArrayList<>(stack));
    for (int i=0;i<nums.size();i++){
      stack.add(nums.get(i));
      List<Integer> copyList = new ArrayList<>(nums);
      copyList.remove(i);
      nextPermutation(copyList,result,stack);
      stack.pop();
    }
  }
}
