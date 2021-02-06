package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 301. 删除无效的括号
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

 说明: 输入可能包含了除 ( 和 ) 以外的字符。

 示例 1:

 输入: "()())()"
 输出: ["()()()", "(())()"]
 示例 2:

 输入: "(a)())()"
 输出: ["(a)()()", "(a())()"]

 思路 : 利用递归进行解答，用一个int 来代表括号，左括号+1  右括号 -1
       当stack < 0 的时候，闭括号少了，然后从左边开始删除第一个闭括号
       当stack > 0 需要
 */
public class RemoveInvalidParentheses$$retry {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        hepler(s,0,0,res,new char[]{'(',')'});
        return res;
    }

    private void hepler(String s, int left , int right, List<String> res,char[] pars){//pars 表示括号的顺序
        int stack  = 0;
        int n = s.length();
        while (right < n){
            char c = s.charAt(right);
            if (c == pars[0]){
                stack++;
            }else if (c == pars[1]){
                stack--;
            }
            if (stack < 0) break;
            right++;
        }
        if (stack < 0){
            while (left <= right){
                char c = s.charAt(left);
                if (c != pars[1]) continue;
                if (left >=1 && s.charAt(left) == s.charAt(left-1)) continue;
                hepler(s.substring(0,left)+s.substring(left+1),left,right,res,pars);
                left++;
            }
        }else if (stack > 0){
            hepler(new StringBuilder(s).reverse().toString(),0,0,res,new char[]{')','('});
        }else {
            res.add(pars[0] == '(' ? s:new StringBuilder(s).reverse().toString());
        }
    }
}


