package depth_first_search;

import java.util.Stack;

/**
 * 394. 字符串解码
 *
 * 定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 遇见各种括号就用栈！
 */
public class DecodeString$$SOS {
    public String decodeString(String s) {
        StringBuilder  res = new StringBuilder();
        Stack<String> stack_res = new Stack<>();
        Stack<Integer> stack_num = new Stack<>();
        int cur_num = 0;
        for (char c : s.toCharArray()){
            if (c == '['){
                stack_num.add(cur_num);
                stack_res.add(res.toString());
                res = new StringBuilder();
                cur_num = 0;
            }else if (c == ']'){
                StringBuilder sb = new StringBuilder();
                int current_num = stack_num.pop();
                while (current_num -->0) sb.append(res);
                res = new StringBuilder(stack_res.pop() + sb);
            }else if (c >='0' && c<='9'){
                cur_num = Integer.valueOf(c+"");
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString$$SOS().decodeString("3[a2[c]]"));
    }
}
