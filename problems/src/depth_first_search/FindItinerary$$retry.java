package depth_first_search;

import java.util.*;

/**
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 * 所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 *
 * 说明:
 *
 * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 示例 1:
 *
 * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2:
 *
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
public class FindItinerary$$retry {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();
        if (tickets == null || tickets.size() < 1) return ans;
        // 构造邻接表
        HashMap<String, List<String>> map = new HashMap<>();
        for (List<String> e : tickets) {
            List<String> edge = map.computeIfAbsent(e.get(0), k -> new ArrayList<>());
            edge.add(e.get(1));
        }
        dfs(map,ans,"JFK");
        return ans;
    }

    void dfs(HashMap<String, List<String>> map, List<String> ans, String start) {
        List<String> edge = map.get(start);
        while (edge != null && edge.size() > 0) {
            String p = edge.remove(0);
            dfs(map, ans, p);
        }
        //
        ans.add(0, start);
    }

    public static void main(String[] args) {
        List<List<String>> root = new ArrayList<>();
        List<String> list1 = Arrays.asList("JFK","SFO");
        List<String> list2 = Arrays.asList("JFK","ATL");
        List<String> list3 = Arrays.asList("SFO","ATL");
        List<String> list4 = Arrays.asList("ATL","JFK");
        List<String> list5 = Arrays.asList("ATL","SFO");
        root.add(list1);
        root.add(list2);
        root.add(list3);
        root.add(list4);
        root.add(list5);
        System.out.println(new FindItinerary$$retry().findItinerary(root));
    }
}