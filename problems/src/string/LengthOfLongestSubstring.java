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
 *
 * 思路： 滑动窗口
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        while (right < s.length()){
            if (right > 0 && !s.substring(left, right).contains(String.valueOf(s.charAt(right)))){
                res = res>right - left + 1?res:right - left + 1;
            }else {
                left = !s.substring(left, right).contains(String.valueOf(s.charAt(right))) ?right:s.substring(left, right).indexOf(String.valueOf(s.charAt(right)))+1;
                s = s.substring(left);
                left = 0;right =0;
            }
            right++;
        }
        if (res == Integer.MIN_VALUE)
            return 1;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
