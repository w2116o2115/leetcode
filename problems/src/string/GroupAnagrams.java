package string;

import java.util.*;

/**
 * 49. 字母异位词分组
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        Map<Set<String>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (Map.Entry<Set<String>, List<String>> enty : map.entrySet()) {
                if (enty.getKey().contains(strs[i])) {
                    enty.getValue().add(strs[i]);
                    flag = false;
                }
            }
            if (flag) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(getAll(strs[i]), list);
            }
        }
        for (Map.Entry<Set<String>, List<String>> enty : map.entrySet()) {
            lists.add(enty.getValue());
        }
        return lists;
    }

    private Set<String> getAll(String s) {
        Set<String> res = new TreeSet<>();
        Set<Character> ss = new TreeSet<>();
        for (char c : s.toCharArray()) {
            ss.add(c);
        }
        backTrack(res, ss, "");
        return res;
    }

    private void backTrack(Set<String> set, Set<Character> ss, String cur) {
        if (ss.size() == 0) {
            set.add(cur);
            return;
        }
        for (char c : ss) {
            Set<Character> cs = new TreeSet<>(ss);
            cs.remove(c);
            backTrack(set, cs, cur + c);
        }
    }

    public static void main(String[] args) {
        Set<String> res = new TreeSet<>();
        List<List<String>> lists = new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(1);
    }
}
