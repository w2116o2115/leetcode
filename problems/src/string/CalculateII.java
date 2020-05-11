package string;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 227. 基本计算器 II
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 *
 * 字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 *
 * 示例 1:
 *
 * 输入: "3+2*2"
 * 输出: 7
 * 示例 2:
 *
 * 输入: " 3/2 "
 * 输出: 1
 * 示例 3:
 *
 * 输入: " 3+5 / 2 "
 * 输出: 5
 */
public class CalculateII {
    public int calculate(String s) {
        s = s.replace(" ","");
        Stack<String> stack = new Stack<>();
        char[] c = s.toCharArray();
        for (int i=0;i<c.length;i++){
            switch (c[i]) {
                case '+':
                    stack.add("+");
                    break;
                case '-':
                    stack.add("-");
                    break;
                case '*':
                    int sum = Integer.parseInt(stack.pop()) * (c[i+1] -'0');
                    stack.add(String.valueOf(sum));
                    i++;
                    break;
                case '/':
                    int div  = Integer.parseInt(stack.pop()) / (c[i+1] -'0');
                    stack.add(String.valueOf(div));
                    i++;
                    break;
                default:
                    stack.add(String.valueOf(c[i] - '0'));
            }
        }
        int res = 0;
        while (!stack.isEmpty()){
            String next = stack.pop();
            if ("+".equals(next)){
                res+=Integer.parseInt(stack.pop());
            }else if ("-".equals(next)){
                res-=Integer.parseInt(stack.pop());
            }else {
                res =+ Integer.parseInt(next);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CalculateII().calculate(" 3+5 / 2 "));
    }
}