package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 */
public class PalindromePartitioning$M {

  public static void main(String[] args) {
    int[] candidates = {10,1,2,7,6,1,5};

    List<List<String>> result = new PalindromePartitioning$M().partition("aab");
    System.out.println(result);
  }

  public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    backtrack(res, s,  new ArrayList<>());
    return res;

  }

  private void backtrack(List<List<String>> res, String s, ArrayList<String> tmp) {
    if (s == null || s.length() == 0){
      res.add(new ArrayList<>(tmp));
      return;
    }

    for (int i=1;i<=s.length();i++){
      if (isPalidrome(s.substring(0,i))){
        tmp.add(s.substring(0,i));
        backtrack(res,s.substring(i),tmp);
        tmp.remove(tmp.size()-1);
      }
    }
  }

  private  boolean isPalidrome(String sb) {
    int left = 0;
    int right = sb.length()-1;
    while (left<right){
      if (sb.charAt(left)!= sb.charAt(right)) return false;
      left++;
      right--;
    }
    return true;
  }
}
