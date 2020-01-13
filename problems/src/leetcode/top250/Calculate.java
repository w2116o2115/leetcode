package leetcode.top250;

import java.util.LinkedList;
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
public class Calculate {
    public int calculate(String exp) {
        return calRst(backTempExp(exp));
    }
    // 计算后缀表达式
    public static LinkedList<String> backTempExp(String exp) {

        Stack<String> stkEles = new Stack<>();
        LinkedList<String> tempBackExp = new LinkedList<>();
        for (int i = 0; i < exp.length(); i++) {
            // 1.遇到了数字
            if (Character.isDigit(exp.charAt(i))) {
                // 注意多位数的获取
                int k = i + 1;
                for (; k < exp.length() && Character.isDigit(exp.charAt(k)); k++) {

                }
                tempBackExp.add(exp.substring(i, k));
                i = k - 1;// 更新 i
                continue;
            }
            // 2.遇到了乘除运算符
            if (exp.charAt(i) == '/' || exp.charAt(i) == '*') {

                while (!stkEles.isEmpty() && (stkEles.lastElement().equals("/") || stkEles.lastElement().equals("*"))) {
                    tempBackExp.add(stkEles.pop()); // 弹出优先级相同或以上的栈内运算符
                }
                stkEles.add(String.valueOf(exp.charAt(i))); // 运算符入栈
                continue;
            }
            // 3.遇到了加减运算符
            if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
                while (!stkEles.isEmpty() && !isNumeric(stkEles.lastElement())) {
                    tempBackExp.add(stkEles.pop()); // 弹出优先级相同或以上的栈内运算符
                }
                stkEles.add(String.valueOf(exp.charAt(i))); // 运算符入栈
            }
        }
        // 4.最后弹出栈内所有元素到表达式
        while (stkEles.size() > 0) {
            tempBackExp.add(stkEles.pop());
        }
        return tempBackExp;
    }

    // 计算最终的结果
    public static int calRst(LinkedList<String> tempBackExp) {
        Stack<Integer> calStk = new Stack<Integer>();
        for (String c : tempBackExp) {
            // 1.数字，入栈
            if (isNumeric(c)) {
                calStk.push(Integer.valueOf(c)); // string to int
            }
            // 2.非数字，则为符号，出栈两个元素计算出结果然后再入栈该计算值
            else {
                int a = calStk.pop();
                int b = calStk.pop();
                switch (c.toCharArray()[0]) {
                    // 注意减法和除法时，注意出栈的顺序与原表达式是相反的

                    case '+':
                        calStk.push(b + a);
                        continue;
                    case '-':
                        calStk.push(b - a);
                        continue;
                    case '*':
                        calStk.push(b * a);
                        continue;
                    case '/':
                        calStk.push(b / a);
                }
            }
        }
        return calStk.pop();
    }

    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
