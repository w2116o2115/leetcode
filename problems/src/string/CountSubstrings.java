package string;

/**
 * 647. 回文子串
 *
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
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 */
public class CountSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i=0;i<=s.length();i++){
            for (int j=i;j<=s.length();j++){
                if (isSub(s.substring(i,j)))
                    count++;
            }
        }
        return count;
    }

    private boolean isSub(String s){
        if ("".equals(s.trim()))
            return false;
        char[] ss = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=ss.length-1;i>=0;i--){
            sb.append(ss[i]);
        }
        String rev = sb.toString();
        return rev.equals(s);
    }

    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("aaa"));
    }
}
