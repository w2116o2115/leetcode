package string.easy;

import java.util.Arrays;

/**
 * 14. 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0)
            return "";
        if (len == 1)
            return strs[0];

        String s = strs[0];
        String res = "";
        for (int i = 1; i <= s.length(); i++) {
            String fix = s.substring(0, i);
            for (int k=1;k < len;k++) {
                if (strs[k].indexOf(fix) < 0) return res;
                if (!fix.equals(strs[k].substring(0, i))) {
                    return res;
                }
            }
            res = fix;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"b","a"}));
    }
}
