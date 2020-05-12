package string;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int rest = 0;
        for (int len = 1;len<=s.length();len++){
            for (int start=0;start<s.length();start++){
                int end = start+len-1;
                if (end == s.length()) break;
                if ((len==1 || (len ==2 && s.charAt(start)==s.charAt(end)) || (s.charAt(start)==s.charAt(end) && dp[start+1][end-1]))){
                    dp[start][end] = true;
                    rest++;
                }
            }
        }
        return rest;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("aaa"));
    }
}