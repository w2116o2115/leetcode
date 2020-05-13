package string;

import java.util.Stack;

/**
 * 678. 有效的括号字符串
 * 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 *
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 ( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: True
 * 示例 2:
 *
 * 输入: "(*)"
 * 输出: True
 * 示例 3:
 *
 * 输入: "(*))"
 * 输出: True
 * dfs:
 * 先编写无 * 情况的代码
 *  count 记录左括号个数
 *  遇左则增，遇右则减
 *  若不够减则 return false
 * 补充有 '*' 的情况
 *  分别开出三种可能继续探索
 *  任何一种成了即可
 */
public class CheckValidString$$SOS {
    public boolean checkValidString(String s) {
        return check(s,0,0);
    }

    private boolean check(String s,int start,int count){
        if (count<0)
            return false;
        for (int i = start;i<s.length();i++){
            int c = s.charAt(i);
            if (c == '('){
                count++;
            }else if (c == ')'){
                if (count-- == 0) return false;
            }else if (c == '*'){
                return  check(s, i + 1, count + 1) ||  // 作为 (
                        check(s, i + 1, count - 1) || // 作为 )，抵消一个左括号
                        check(s, i + 1, count);       // 作为 空
            }
        }
        return count == 0;
    }
}