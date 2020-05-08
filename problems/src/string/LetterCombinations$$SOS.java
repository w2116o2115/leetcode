package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 思路： 回溯
 */
public class LetterCombinations$$SOS {
    public List<String> letterCombinations(String digits) {
        List<String> rest = new ArrayList<>();
        backTrad(digits,"",rest);
        return rest;
    }

    private void backTrad(String next_digits,String str,List<String> rest){
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if (next_digits.length() == 0) {
            rest.add(str);
        }else {
            String digit = next_digits.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                backTrad(next_digits.substring(1), str + letters.substring(i, i + 1), rest);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations$$SOS().letterCombinations("23"));
    }
}
