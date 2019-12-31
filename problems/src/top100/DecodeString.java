package top100;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
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
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> chars= new Stack<>();
        char[] cs = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int multi = 0;
        for (char c:cs){
            if (c>='0' && c<='9'){
                multi = multi * 10 + Integer.valueOf(String.valueOf(c));
            }else if (c == '['){
                nums.add(multi);
                chars.add(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if (c == ']'){
                int count = nums.pop();
                String temp = "";
                while (count --> 0){
                    temp += res;
                }
                res = new StringBuilder();
                res.append(chars.pop()).append(temp);
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("100[leetcode]"));
    }
}
