package leetcode.top250;

import java.util.ArrayList;
import java.util.List;

/**
 * 241. 为运算表达式设计优先级
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。
 * 有效的运算符号包含 +, - 以及 * 。
 *
 * 示例 1:
 *
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2:
 *
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 *
 * 思路:
 *     一看到题就觉得有点复杂，可以考虑一下递归的方式，去寻找子问题和原问题解的关系。
 *     可以通过运算符把整个式子分成两部分，两部分再利用递归解决。
 *     以 2 * 3 - 4 * 5 为例。
 *     2 和 3 - 4 * 5 两部分，中间是 * 号相连。
 *     2 * 3 和 4 * 5 两部分，中间是 - 号相连。
 *     2 * 3 - 4 和 5 两部分，中间是 * 号相连。
 *     有了两部分的结果，然后再通过中间的符号两两计算加入到最终的结果中即可。
 *     比如第一种情况，2 和 3 - 4 * 5 两部分，中间是 * 号相连。
 *     2 的解就是 [2]，3 - 4 * 5 的解就是 [-5, -17]。
 *     把两部分解通过 * 号计算，最终结果就是 [-10, -34]。
 *     另外两种情况也类似。
 *     然后还需要递归出口。
 *     如果给定的字符串只有数字，没有运算符，那结果就是给定的字符串转为数字。
 */
public class DiffWaysToCompute {
    public List<Integer> diffWaysToCompute(String input) {
        return partition(input);
    }

    public List<Integer> partition(String input) {
        List<Integer> result = new ArrayList<>();
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.valueOf(input));
            return result;
        }
        for(int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                for(Integer left : partition(input.substring(0, i))) {
                    for (Integer right : partition(input.substring(i + 1))) {
                        if (input.charAt(i) == '+') {
                            result.add(left + right);
                        } else if (input.charAt(i) == '-') {
                            result.add(left - right);
                        } else if (input.charAt(i) == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DiffWaysToCompute().partition("2*3-4*5"));
    }
}
