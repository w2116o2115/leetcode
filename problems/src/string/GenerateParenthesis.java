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
 */
public class GenerateParenthesis {
    private void bankTrade(int n, int start, int end, List<String> rst, StringBuilder sb) {
        if (sb.length() == n*2) {
            rst.add(sb.toString());
            return;
        }
        if (start < n) {
            bankTrade(n, start + 1, end, rst, sb.append("("));
            sb.deleteCharAt(sb.length()-1);
        }
        if (end < start){
            bankTrade(n, start, end+1, rst, sb.append(")"));
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        bankTrade(n, 1, 0, res, new StringBuilder().append("("));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
