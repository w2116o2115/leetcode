package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 791. 自定义字符串排序
 *
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 *
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 *
 * 返回任意一种符合条件的字符串T。
 *
 * 示例:
 * 输入:
 * S = "cba"
 * T = "abcd"
 * 输出: "cbad"
 * 解释:
 * S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 * 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 */
public class CustomSortString {
    public String customSortString(String S, String T) {
        Set<Character> set1 = new TreeSet<>();
        Map<Character,Integer> map = new HashMap<>();
        char[] ss = S.toCharArray();
        char[] tt = T.toCharArray();
        for (char t : tt){
            set1.add(t);
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char s : ss){
            if (set1.contains(s)){
                int num = map.get(s);
                while (num --> 0){
                    sb.append(s);
                }
                set1.remove(s);
            }
        }
        String res = sb.toString();
        for (char n:set1){
            int num = map.get(n);
            while (num --> 0){
                res = res + n;
            }
        }
        return res;
    }
}
