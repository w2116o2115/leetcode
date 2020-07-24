package leetcode.top100;

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
 *
 * 滑动窗口算法的思路是这样：
 *
 * 1、我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，把索引闭区间 [left, right] 称为一个「窗口」。
 *
 * 2、我们先不断地增加 right 指针扩大窗口 [left, right]，直到窗口中的字符串符合要求（包含了 T 中的所有字符）。
 *
 * 3、此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right]，直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。
 *    同时，每次增加 left，我们都要更新一轮结果。
 *
 * 4、重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
//        List<Integer> list = new ArrayList<>();
//        if (p.length() > s.length())
//            return list;
//        Set<String> set = getSet(p);
//        for (int i=0;i<=s.length()-p.length();i++){
//            System.out.println(s.substring(i,i+p.length()));
//            if (set.contains(s.substring(i,i+p.length()))){
//                list.add(i);
//            }
//        }
//        return list;
//    }
//
//    private Set<String> getSet(String p){
//        Set<String> set = new HashSet<>();
//        bankTrack(p.toCharArray(),new boolean[p.length()],new StringBuilder(),set);
//        return set;
//    }
//
//    private void bankTrack(char[] s, boolean[] visited, StringBuilder queue,Set<String> set){
//        if (queue.length() == s.length){
//            set.add(queue.toString());
//        }
//        for (int i=0;i<s.length;i++){
//            if (visited[i]) continue;
//            queue.append(s[i]);
//            visited[i] = true;
//            bankTrack(s,visited,queue,set);
//            queue.deleteCharAt(queue.length()-1);
//            visited[i] = false;
//        }
        // 用数组记录答案
        List<Integer> res = new ArrayList<>();
        int left = 0;int right = 0;
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (char c:p.toCharArray()) need.put(c,need.getOrDefault(c,0)+1);
        int match = 0;
        while (right < s.length()){
            char c1 = s.charAt(right);
            if (need.containsKey(c1)){
                window.put(c1,window.getOrDefault(c1,0)+1);
                if (window.get(c1).equals(need.get(c1))){
                    match++;
                }
            }
            right++;
            while (match == need.size()){
                if (right - left == p.length()) res.add(left);
                char c2 = s.charAt(left);
                if (need.containsKey(c2)){
                    window.put(c2,window.get(c2)-1);
                    if (window.get(c2) < need.get(c2))
                        match--;
                }
                left--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams("ccabab","ab"));
    }
}
