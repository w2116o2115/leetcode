package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        bankTrack(res,"",0,0,n);
        return res;
    }

    private void bankTrack(List<String> res,String cur,int open,int close,int max){
        if (cur.length() == max*2){
            res.add(cur);
            return;
        }

        if (open < max){
            bankTrack(res,cur + "(",open+1,close,max);
        }
        if (close < open){
            bankTrack(res,cur + ")",open,close+1,max);
        }
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }
}
