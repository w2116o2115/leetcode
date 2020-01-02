package top100;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *
 * 滑动窗口
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length())
            return list;
        Set<String> set = getSet(p);
        for (int i=0;i<=s.length()-p.length();i++){
            System.out.println(s.substring(i,i+p.length()));
            if (set.contains(s.substring(i,i+p.length()))){
                list.add(i);
            }
        }
        return list;
    }

    private Set<String> getSet(String p){
        Set<String> set = new HashSet<>();
        bankTrack(p.toCharArray(),new boolean[p.length()],new StringBuilder(),set);
        return set;
    }

    private void bankTrack(char[] s, boolean[] visited, StringBuilder queue,Set<String> set){
        if (queue.length() == s.length){
            set.add(queue.toString());
        }
        for (int i=0;i<s.length;i++){
            if (visited[i]) continue;
            queue.append(s[i]);
            visited[i] = true;
            bankTrack(s,visited,queue,set);
            queue.deleteCharAt(queue.length()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams("abab","ab"));
    }
}
