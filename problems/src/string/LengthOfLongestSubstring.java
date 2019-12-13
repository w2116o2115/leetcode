package string;

import java.util.Arrays;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 子串  问题就是  动态规划问题
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s))
            return 0;
        if (s.length() == 1)
            return 1;
        char[] c = s.toCharArray();
        int[] dp = new int[s.length()];
        Arrays.fill(dp,1);
        int res = 0;
        int start = 0;
        boolean flag = false;
        for (int i=1;i<c.length;i++){
            for (int j=start;j<i;j++) {
                if (c[i] == c[j]) {
                    flag = !flag;
                    start = j+1;
                    break;
                }
            }
            if (flag){
                flag = !flag;
                dp[start] = 1;
                i = start;
            }else {
                dp[i] = dp[i-1] + 1;
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("dvdf"));
    }
}
