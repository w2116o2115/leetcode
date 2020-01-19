package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
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
public class GenerateParentheses$M {
    public static void main(String[] args) throws Exception {
        System.out.println(new GenerateParentheses$M().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, "", 0, 0, n);
        return list;
    }

    private void backTrack(List<String> list, String str, int open, int close, int n) {
        if (str.length() == 2*n){
            list.add(str);
        }

        if (open < n){
            backTrack(list,str+"(",open+1,close,n);
        }
        if (open > close){
            backTrack(list,str+")",open,close+1,n);
        }
    }
}
