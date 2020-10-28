package breadth_first_search;

import java.util.*;

/**
 * 210. 课程表 II
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 *
 * BFS 的总体思路：
 *
 * 建立入度表，入度为 0 的节点先入队
 * 当队列不为空，节点出队，标记学完课程数量的变量加 1，并记录该课程
 * 将课程的邻居入度减 1
 * 若邻居课程入度为 0，加入队列
 * 用一个变量记录学完的课程数量，一个数组记录最终结果，简洁好理解。
 * DFS 的总体思路：
 *
 * 建立邻接矩阵
 * DFS 访问每一个课程，若存在环直接返回
 * status 保存课程的访问状态，同一个栈保存课程的访问序列。
 */
public class FindOrder$$retry {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] res = new int[numCourses];
        int[] inDegree = new int[numCourses];
        for (int[] pre:prerequisites){//建立邻接表
            List<Integer> list = map.getOrDefault(pre[1],new ArrayList<>());
            list.add(pre[0]);
            map.put(pre[1],list);
            //建立入度表
            inDegree[pre[0]]++;
        }
        for (int i=0;i<inDegree.length;i++){
            if (inDegree[i] != 0) continue;
            int[] status = new int[numCourses];
            Stack<Integer> stack = new Stack<>();
            if (dfs(map,status,inDegree[i],stack)){
                int sum = 0;
                while (!stack.isEmpty()) {
                    res[sum++] = stack.pop();
                }
            }
        }
        return res;
    }

    private boolean dfs(Map<Integer, List<Integer>> map, int[] status, int i, Stack<Integer> stack) {
        if (status[i] == 1) return false; // 当前节点在此次 dfs 中正在访问，说明存在环
        if (status[i] == -1) return true;

        status[i] = 1;
        List<Integer> list = map.get(i) == null?new ArrayList<>():map.get(i);
        for (int num:list){
            if (!dfs(map, status, num, stack)) return false;
        }
        status[i] = -1;  // 标记为已访问
        stack.push(i);
        return true;
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        int[] rest = new FindOrder$$retry().findOrder(4,prerequisites);
        System.out.println(1);
    }
}