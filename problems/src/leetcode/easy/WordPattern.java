package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> map = new HashMap<>();
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) return false;
        for (int i=0;i<pattern.length();i++){
            if (map.containsKey(pattern.charAt(i))){
                if (!strs[i].equals(map.get(pattern.charAt(i)))) return false;
            }else {
                if (map.containsValue(strs[i])) return false;
                map.put(pattern.charAt(i),strs[i]);
            }
        }
        return true;
    }
}
