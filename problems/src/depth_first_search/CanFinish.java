package depth_first_search;

import java.util.*;

/**
 * 207. 课程表
 *
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
 * 思路 :通拓扑排序思路
 *
 * 不能“跳步”，选你能上的课
 *  当下只能选 入度为 0 的课，因为它不依赖别的课。假设先选了 0
 *  这导致 依赖 0 的课的入度减小 —— 3 的入度由 2 变 1
 *  接着选 1，导致课 3 的入度变 0，课 4 的入度由 2 变 1
 *  接着选 2，导致课 4 的入度变 0，当前 3 和 4 入度为 0
 *  继续选 入度为 0 的课
 *  ……
 *  直到选不到 入度为 0 的课
 *
 * 这形似 树的BFS
 *  起初让 入度为 0 的课 入列
 *  然后 逐个出列，课出列 = 课被选，减小相关课的入度
 *  判定是否有 入度转 0 的课，继续入列、出列……
 *  直到没有 入度为 0 的课 可入列……
 *
 * BFS 前的准备工作
 *  我们关心【每门课对应的入度】—— 它要被减，要被监控
 *  我们关心【课之间的依赖关系】—— 选这门课会减小哪些课的入度
 *  因此我们需要 合适的数据结构，去存储这些关系
 *  构建入度数组
 *  每一门课都有一个动态变化的入度
 *  课的编号是 0 到 n - 1，让它作为索引，选用 数组 存放入度
 *  遍历先决条件表，计算每门课的初始入度
 *
 * 构建哈希表
 *  我们选用 哈希表 即 相邻衔接表 来记录 依赖关系
 *  map 存键值对：
 *  键： 课的编号
 *  值： 依赖它的后续课程
 *  比如：修完 2 才能修 4 和 5
 *  2: [4, 5]
 *  也可以用 邻接矩阵，但它有点大
 *
 * BFS 思路
 *  queue 队列中始终是 入度为 0 的课 在流动
 *  选择一门课，就让它 出列，同时 查看哈希表，看它 有哪些后续课
 *  将这些后续课的 入度 - 1，如果有 减至 0 的，就将它 入列
 *  不再有新的入度 0 的课入列 时，此时 queue 为空，退出循环
 *
 * 判断条件
 *  遍历完所有的课，如果 仍有课的入度不为 0，说明它无法入列，代表选不了它
 *  遍历入度数组，有课的入度不为 0 ，则返回false，说明完成不了所有课程
 *  否则，返回true，能找到一种排序，完成所有课程
 */
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) return false;
        //建立邻接表
        Map<Integer, List<Integer>> map = new HashMap<>();
        //建立入度表
        int[] degree = new int[numCourses];
        for (int i=0;i<prerequisites.length;i++){
            List<Integer> list = map.getOrDefault(prerequisites[i][1],new ArrayList<>());
            list.add(prerequisites[i][0]);
            map.put(prerequisites[i][1],list);
            degree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=0;i<degree.length;i++){
            if (degree[i] == 0) queue.offer(i);
        }
        bfs(map,degree,queue);
        for (int i=0;i<degree.length;i++){
            if (degree[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * 广度优先遍历
     * @param map
     * @param degree
     * @param queue
     * @return
     */
    private void bfs(Map<Integer, List<Integer>> map,int[] degree,Queue<Integer> queue) {
        while (!queue.isEmpty()){
            List<Integer> list = map.get(queue.poll());
            if (list==null || list.size() <= 0) continue;
            for (int next:list){
                degree[next]--;
                if (degree[next] == 0)
                    queue.offer(next);
            }
        }
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1,0}};
        System.out.println(new CanFinish().canFinish(numCourses,prerequisites));
    }
}
