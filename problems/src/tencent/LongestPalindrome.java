package tencent;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        int max = Integer.MIN_VALUE;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int len = 1;len<s.length();len++){
           for (int strar=0;strar<s.length();strar++){
               int end = strar+len-1;
               if (end >= s.length())
                   break;
               dp[strar][end] = (len == 1 || len ==2 || dp[strar+1][end-1]) && s.charAt(strar) == s.charAt(end);
               if (dp[strar][end]){
                    if (len > max){
                        res = s.substring(strar,end+1);
                        max = len;
                    }
               }
           }
        }
        return res;
    }

    public static void main(String[] args) {
        String x = "babad";
        System.out.println(new LongestPalindrome().longestPalindrome(x));
    }
}