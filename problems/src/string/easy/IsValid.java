package string.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValid {
    public boolean isValid(String s) {
        if ("".equals(s.trim())){
            return true;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(c[0]);
        for (int i=1;i<c.length;i++){
            if ('(' == c[i] || '[' == c[i] || '{' == c[i] ){
                stack.push(c[i]);
            }else {
                if (stack.isEmpty()) return false;
                if (!map.containsKey(stack.peek())) return false;
                if (c[i] != map.get(stack.pop())) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid(")}{({))[{{[}"));
    }
}
