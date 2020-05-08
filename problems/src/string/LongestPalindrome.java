package string;

import java.util.Arrays;

/**
 * 5. 最长回文子串
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
 *
 * 创造二维数组  标识 从 i 到 j的字符串是否是回文子串
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len=1;len<s.length();len++){
            for (int start = 0;start<s.length();start++){
                int end = start+len-1;
                if (end >= s.length()) break;
                if ((len == 1 || len == 2 || dp[start+1][end-1]) && s.charAt(start) == s.charAt(end)){
                    dp[start][end] = true;
                    res = res.length() > end-start+1?res:s.substring(start,end+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("cbbd"));
    }
}
