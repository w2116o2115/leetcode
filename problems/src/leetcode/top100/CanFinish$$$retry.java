package leetcode.top100;

import java.util.*;

/**
 * 207. 课程表
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * 图论  邻接矩阵  查环儿
 */
public class CanFinish$$$retry {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //建立邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();
        //入度表
        int[] inDegree = new int[numCourses];

        for (int[] x:prerequisites){
            List<Integer> list = map.getOrDefault(x[1],new ArrayList<>());
            list.add(x[0]);
            map.put(x[1],list);
            inDegree[x[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int degree:inDegree){
            if (degree == 0)
                queue.offer(degree);
        }

        dfs(inDegree,queue,map);

        for (int degree:inDegree){
            if (degree != 0)
                return false;
        }

        return true;
    }

    private void dfs(int[] inDegrees ,Queue<Integer> queue,Map<Integer, List<Integer>> map){
        while (!queue.isEmpty()){
            List<Integer> list = map.get(queue.poll());
            if (list == null || list.size() == 0) continue;
            for (int next:list){
                inDegrees[next]--;
                if (inDegrees[next] == 0)
                    queue.offer(next);
            }
        }
    }
}
