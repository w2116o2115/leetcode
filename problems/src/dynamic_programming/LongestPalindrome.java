package dynamic_programming;

/**
 * 5.最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] flag = new boolean[length][length];
        int max = Integer.MIN_VALUE;
        String maxString = "";
        for (int len =1;len <=length;len ++){
            for (int start = 0;start < length ; start ++){
                int end = start + len -1;
                if (end >= length)
                    break;
                int lang = end - start;
                flag[start][end] = (len == 1 || len == 2 || flag[start+1][end-1]) && s.charAt(start) == s.charAt(end);
                if (flag[start][end]){
                    if (lang > max) {
                        max = lang;
                        maxString = s.substring(start, end+1);
                    }
                }
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        String s = "ab";

        System.out.println(new LongestPalindrome().longestPalindrome(s));
    }
}
