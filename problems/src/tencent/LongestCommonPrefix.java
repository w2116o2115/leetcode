package tencent;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 方法： 分治
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else {
            return longestCommonPrefix(strs, 0, strs.length - 1);
        }
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        }else {
            int mid = (start+end) >> 1;
            String left = longestCommonPrefix(strs,start,mid);
            String right = longestCommonPrefix(strs,mid+1,end);
            return commonPrefix(left,right);
        }
    }

    public String commonPrefix(String lcpLeft, String lcpRight) {
        int maxLen = Math.min(lcpLeft.length(),lcpRight.length());
        for (int i=0;i<maxLen;i++){
            if (lcpLeft.charAt(i) != lcpRight.charAt(i)){
                return lcpLeft.substring(0,i);
            }
        }
        return lcpLeft.substring(0,maxLen);
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}