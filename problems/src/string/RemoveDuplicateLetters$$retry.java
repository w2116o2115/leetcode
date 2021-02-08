package string;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）
 * 输入：s = "bca"
 * 输出："abc"
 *
 * 思路 ： 利用栈的思路，先把字符放入栈，然后进行入栈和出栈的操作，栈可以用字符串进行替换
 *         利用两个数组，来记录 字符出现的最后的位置
 *                      来记录 字符是否被使用过
 *                      只有当前的字符 小于栈顶字符，并且后边还有相关的字符，才进行出栈操作。
 * 思考 ： 所有小写字母的问题都可以考虑用int数组来解决
 */
public class RemoveDuplicateLetters$$retry {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        int[] lastOcurrent = new int[26];
        boolean[] used = new boolean[26];
        for (int i=0;i<n;i++){
            lastOcurrent[s.charAt(i)-'a'] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<n;i++){
            char cur = s.charAt(i);
            if (used[cur-'a']) continue;
            while (sb.length() > 0 && sb.charAt(sb.length()-1) > cur && lastOcurrent[sb.charAt(sb.length()-1)-'a'] > i){
                used[sb.charAt(sb.length()-1) - 'a'] = false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(cur);
            used[cur - 'a'] = true;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters$$retry().removeDuplicateLetters("bca"));
    }
}