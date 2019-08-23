package dynamic_programming;

/**
 * 给定一个字符串s，找到其中最长的回文子序列。可以假设s的最大长度为1000。
 *
 * 示例 1:
 * 输入:
 *
 * "bbbab"
 * 输出:
 *
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 *
 * 示例 2:
 * 输入:
 *
 * "cbbd"
 * 输出:
 *
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 */
public class LongestPaliandromicSubstring {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    System.out.println(new LongestPaliandromicSubstring().longestPalindrome("forgeeksskeegfor"));
  }

  public String longestPalindrome(String s) {
    int l = s.length();
    int startIndex = 0;
    int maxLen = 1;
    boolean[][] A = new boolean[l][l];
    for (int i = 0, j = 0; i < l; i++, j++) A[i][j] = true;

    for (int i = 0, j = i + 1; j < l; i++, j++) {
      if (s.charAt(i) == s.charAt(j)) {
        A[i][j] = true;
        startIndex = i;
        maxLen = 2;
      }
    }

    for (int k = 3; k <= l; k++) {
      for (int i = 0, j = k - 1; j < l; i++, j++) {
        if (s.charAt(i) == s.charAt(j)) {
          A[i][j] = A[i + 1][j - 1];
          if (A[i][j]) {
            if (k > maxLen) {
              startIndex = i;
              maxLen = k;
            }
          }
        }
      }
    }

    return s.substring(startIndex, startIndex + maxLen);
  }
}
