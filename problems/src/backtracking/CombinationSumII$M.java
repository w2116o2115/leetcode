package backtracking;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by gouthamvidyapradhan on 14/03/2017. Given a collection of candidate numbers (C) and a
 * target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * <p>Each number in C may only be used once in the combination.
 *
 * <p>Note: All numbers (including target) will be positive integers. The solution set must not
 * contain duplicate combinations. For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and
 * target 8, A solution set is: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ]
 */
public class CombinationSumII$M {
  public static List<List<Integer>> result = new ArrayList<>();
  public static Map<List<Integer>,Integer> map = new HashMap<>();
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] candidates = {10,1,2,7,6,1,5};

    List<List<Integer>> result = new CombinationSumII$M().combinationSum(candidates, 8);
    System.out.println(result);
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    int sum = 0;
    doNext(candidates.length,new Stack<>(),candidates,target,0);
    return result;
  }

  private static void doNext(int len,Stack<Integer> stack,int[] candidates,int target,int index) {
    int sum = 0;
    for (int num : stack){
      sum += num;
    }
    if (sum > target){
      return;
    }
    if (sum == target){
      List<Integer> list = new ArrayList<>(stack);
      Collections.sort(list);
      if (!map.containsKey(list)){
        map.put(list,1);
        result.add(list);
      }
      return;
    }
    for (int i = index;i<len;i++){
      stack.add(candidates[i]);
      doNext(len,stack,candidates,target,i+1);
      stack.pop();
    }
  }
}

