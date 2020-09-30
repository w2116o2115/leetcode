package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * 思路： 一行一个list
 */
public class Convert$$retry {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> res = new ArrayList<>();
        for (int i=0;i<numRows;i++){
            res.add(new StringBuilder());
        }
        int index = 0;
        boolean flag = false;
        for (int i=0;i<s.length();i++){
            res.get(index).append(s.charAt(i));
            if (index == 0) flag = !flag;
            if (index+1 == numRows) flag = !flag;
            index = flag?++index:--index;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder ss:res){
            sb.append(ss.toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Convert$$retry().convert("LEETCODEISHIRING",4));
    }
}