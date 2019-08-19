package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations$M {

  private static List<List<Integer>> res = new ArrayList<>();

  private static void findCombinations(int n, int k, int begin, Stack<Integer> pre) {
    if (pre.size() == k){
      res.add(new ArrayList<>(pre));
      return;
    }
    for (int i=begin;i<=n;i++){
      pre.add(i);
      findCombinations(n,k,i+1,pre);
      pre.pop();
    }
  }

  private static List<List<Integer>> combine(int n, int k) {
    if (n<=k || n<=0)
      return res;
    findCombinations(n,k,1,new Stack<>());
    return res;
  }

  public static void main(String[] args) {
    List<List<Integer>> combine = combine(4, 2);
    System.out.println(combine);
  }
}
