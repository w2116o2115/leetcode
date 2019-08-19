package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 * 注意：
 *
 * S 的长度不超过12。
 * S 仅由数字和字母组成。
 */
public class LetterCasePermutation$M {

  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new LetterCasePermutation$M().letterCasePermutation("a1b2"));
  }

  public List<String> letterCasePermutation(String S) {
    List<String> result = new ArrayList<>();
    backtrack(S, result, 0, "");
    return result;
  }

  private void backtrack(String s, List<String> result, int i, String r) {
    if (i == s.length()) {
      result.add(r);
    } else {
      if (Character.isAlphabetic(s.charAt(i))) {
        backtrack(s, result, i + 1, r + s.charAt(i));
        if (Character.isLowerCase(s.charAt(i))) {
          backtrack(s, result, i + 1, r + Character.toUpperCase(s.charAt(i)));
        } else {
          backtrack(s, result, i + 1, r + Character.toLowerCase(s.charAt(i)));
        }
      } else {
        backtrack(s, result, i + 1, r + s.charAt(i));
      }
    }
  }
}
