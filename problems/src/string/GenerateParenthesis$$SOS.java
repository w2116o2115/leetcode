package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 22. 括号生成
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * 思路： 回溯
 */
public class GenerateParenthesis$$SOS {
    private void bankTrade(int n, int start, int end, List<String> rst, Stack<String> sb) {
        if (sb.size() == 2*n){
            rst.add(sb.toString().replace(",",""));
        }

        if (start < n){
            sb.add("(");
            bankTrade(n,start+1,end,rst,sb);
            sb.pop();
        }
        if (start>end){
            sb.add(")");
            bankTrade(n,start,end+1,rst,sb);
            sb.pop();
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.add("(");
        bankTrade(n, 1, 0, res, stack);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis$$SOS().generateParenthesis(3));
    }
}
