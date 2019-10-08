package string;

import java.util.Stack;

/**
 * 856. 括号的分数
 *
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 *
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 *  
 * 下面给出了字符串 (()(())) 每次对应的栈的情况：
 *
 * [0, 0] (
 * [0, 0, 0] ((
 * [0, 1] (()
 * [0, 1, 0] (()(
 * [0, 1, 0, 0] (()((
 * [0, 1, 1] (()(()
 * [0, 3] (()(())
 * [6] (()(()))
 *
 * 输入： "(()(()))"
 * 输出： 6
 */
public class ScoreOfParentheses {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        char[] ss = S.toCharArray();
        stack.push(0);
        for (char c:ss){
            if (c == '('){
                stack.push(0);
            }else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w+Math.max(1,2*v));
            }
        }
        return stack.pop();
    }
}
