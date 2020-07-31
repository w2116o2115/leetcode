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
 *
 * 思路：
 * 将表达式（中缀）转化为后缀
 * 将后缀计算出结果
 *
 * 具体规则为：
 * 1.中缀转后缀：
 * - 数字直接输出到后缀表达式
 * - 栈为空时，遇到运算符，直接入栈
 * - 遇到运算符，弹出所有优先级大于或等于该运算符的栈顶元素，并将该运算符入栈
 * - 将栈中元素依次出栈
 *
 * 例如：表达式：3+2 * 2
 * 遇到3，直接输出到后缀表达式中，栈中元素为空，结果为： 栈： 空； 后缀表达式：3
 * 遇到符号“+”，入栈，结果为： 栈：+ ； 后缀表达式：3
 * 遇到2，直接输出，结果为： 栈：+； 后缀表达式： 3 2
 * 遇到乘号*，入栈，结果为： 栈： * + ；后缀表达式：3 2
 * 遇到2，直接输出，结果为： 栈： * + ；后缀表达式：3 2 2
 * 最后，将元素出栈：结果为：后缀表达式：3 2 2 * +
 *
 * 2.计算后缀：
 * - 遇到数字，入栈
 * - 遇到运算符，弹出栈顶两个元素，做运算，并将结果入栈
 * - 重复上述步骤，直到表达式最右端
 *
 * 例如上述得到的后缀表达式为 3 2 2 * +
 * 3 2 2 都是数字，入栈，结果为：栈：2 2 3
 * 遇到* 号， 2 2 出栈，并计算，2*2 = 4, 4入栈，结果为：栈：4 3 ，表达式还剩一个加号
 * 遇到+ 号，栈顶两个元素出栈并运算，4 3 做加法，4+3 =7
 * 后缀表达式空了，计算完毕，输出结果：7
 */
public class Calculate {
    public static void main(String[] args) {
        System.out.println(new Calculate().calculate("3+2*2/2/2"));
    }

    public int calculate(String exp) {
        return calRst(backTempExp(exp));
    }
    // 计算后缀表达式
    public static LinkedList<String> backTempExp(String exp) {

        Stack<String> stkEles = new Stack<>();//符号
        LinkedList<String> tempBackExp = new LinkedList<>();//后缀表达式
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
                continue;
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


    /**
     * 下面以a+b*c+(d*e+f)*g为例子来讲讲计算机的转换过程。下面在描述栈的情况是直接用文字描述了，由左到右为栈底到栈顶。空表示栈空
     *
     * 由左向右遍历表达式，首先遇到a，直接将其输出。
     *
     * 此时输出为：a
     *
     * 栈的情况为：空
     *
     * 继续遍历，遇到+，将其放入栈中。
     *
     * 此时输出为：a
     *
     * 栈的情况为：+
     *
     * 继续遍历，遇到b，直接将其输出。
     *
     * 此时输出为：ab
     *
     * 栈的情况为：+
     *
     * 继续遍历，遇到*，因为*的优先级大于栈顶的+，所以将*放入栈内。
     *
     * 此时输出为：ab
     *
     * 栈的情况为：+*
     *
     * 继续遍历，遇到c，直接将其输出。
     *
     * 此时输出为：abc
     *
     * 栈的情况为：+*
     *
     * 继续遍历，遇到+，因为+的优先级低于栈顶的*，故将*弹出；然后新的栈顶元素的+与这个+优先级相同，故也要弹出现在栈顶的+；然后栈空了，将现在这个+放入栈中。
     *
     * 此时输出为：abc*+
     *
     * 栈的情况为：+
     *
     * 继续遍历，遇到(，直接将其放入栈中，不遇到)不会将(弹出。
     *
     * 此时输出为：abc*+
     *
     * 栈的情况为：+(
     *
     * 继续遍历，遇到d，直接将其输出。
     *
     * 此时输出为：abc*+d
     *
     * 栈的情况为：+(
     *
     * 继续遍历，遇到*，因为栈顶为(,不遇到)不将(弹出,故直接将*放入栈中。
     *
     * 此时输出为：abc*+d
     *
     * 栈的情况为：+(*
     *
     * 继续遍历，遇到e，直接将其输出。
     *
     * 此时输出为：abc*+de
     *
     * 栈的情况为：+(*
     *
     * 继续遍历，遇到+，因为+比栈顶*的优先级低，故将*弹出；新的栈顶元素为(,不遇到)不弹出(,故将+放入栈中。
     *
     * 此时输出为：abc*+de*
     *
     * 栈的情况为：+(+
     *
     * 继续遍历，遇到f，直接将其输出。
     *
     * 此时输出为：abc*+de*f
     *
     * 栈的情况为：+(+
     *
     * 继续遍历，遇到),直接将栈中元素依次弹出并输出直到遇到(为止，注意：(弹出但不输出。
     *
     * 此时输出为：abc*+de*f+
     *
     * 栈的情况为：+
     *
     * 继续遍历，遇到*，因为*的优先级大于栈顶元素+的优先级，故直接将*入栈。
     *
     * 此时输出为：abc*+de*f+
     *
     * 栈的情况为：+*
     *
     * 继续遍历，遇到g，直接将其输出。
     *
     * 此时输出为：abc*+de*f+g
     *
     * 栈的情况为：+*
     *
     * 继续遍历，为空，遍历结束。将栈内元素依次弹出。
     *
     * 此时输出为：abc*+de*f+g*+
     *
     * 栈的情况为：空
     *
     * 至此，中缀表达式转后缀已经全部完成，结果为abc*+de*f+g*+。
     */
}
