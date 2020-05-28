package breadth_first_search;

import java.util.*;

/**
 * 743. 网络延迟时间
 *
 * 有 N 个网络节点，标记为 1 到 N。
 * 给定一个列表 times，表示信号经过有向边的传递时间。 times[i] = (u, v, w)，其中 u 是源节点，v 是目标节点， w 是一个信号从源节点传递到目标节点的时间。
 * 现在，我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1。
 *
 * 示例：
 *   2
 * /    \
 *1      3
 *      /
 *     4
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 * 输出：2
 *
 * https://www.cnblogs.com/thousfeet/p/9229395.html
 * 思路：这题目是一个有向图求最短路径的问题，求出K点到每一个点到最短路径，然后取其中最大的一个就是需要的时间了。
 * Dijkstra算法介绍
 * 何为Dijkstra算法？
 *
 * Dijkstra算法功能：给出加权连通图中一个顶点，称之为起点，找出起点到其它所有顶点之间的最短距离。
 *
 * Dijkstra算法思想：采用贪心法思想，进行n-1次查找（PS:n为加权连通图的顶点总个数，除去起点，则剩下n-1个顶点），
 * 第一次进行查找，找出距离起点最近的一个顶点，标记为已遍历；下一次进行查找时，从未被遍历中的顶点寻找距离起点最
 * 近的一个顶点， 标记为已遍历；直到n-1次查找完毕，结束查找，返回最终结果。
 */
public class NetworkDelayTime$$SOS {
    public int networkDelayTime(int[][] times, int N, int K) {
        // 构建邻接矩阵，用于存放各个点到各个点的距离
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                graph[i][j] = -1;
            }
        }
        // 遍历times填充邻接表
        for (int[] time : times) {
            graph[time[0]][time[1]] = time[2];
        }

        // 存放 K 到各个点的最短路径，最大的那个最短路径即为结果
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);

        // 初始化 distance 为 K 到各个节点的距离
        for (int i = 1; i <= N; i++) {
            distance[i] = graph[K][i];
        }
        // K到达K本身的节点初始化为 0
        distance[K] = 0;

        // 判断是否找到K到达该点最短路径
        boolean[] visited = new boolean[N + 1];
        visited[K] = true;

        // 遍历除K本身节点之外的所有N-1个节点
        for (int i = 1; i <= N - 1; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minIndex = 1;
            // 遍历所有节点，找到离K最近的节点
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && distance[j] != -1 && distance[j] < minDistance) {
                    minDistance = distance[j];
                    minIndex = j;
                }
            }

            // 标记最近距离节点找到
            visited[minIndex] = true;

            // 根据刚刚找到的最短距离节点，通过该节点更新K节点与其他的节点的距离
            for (int j = 1; j <= N; j++) {
                // 如果已更新的最短节点可以到达当前节点
                if (graph[minIndex][j] != -1) {
                    if (distance[j] != -1) {
                        // 取之前路径与当前更新路径的最小值
                        distance[j] = Math.min(distance[j], distance[minIndex] + graph[minIndex][j]);
                    } else {
                        // 该节点是第一次访问，直接更新
                        distance[j] = distance[minIndex] + graph[minIndex][j];
                    }
                }
            }
        }

        int maxDistance = 0;
        // 遍历最大值，如果有节点未被访问，返回 -1，否则返回最大最短路径
        for (int i = 1; i <= N; i++) {
            if (distance[i] == -1) {
                return -1;
            }
            maxDistance = Math.max(distance[i], maxDistance);
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        int[][] times = new int[][]{{1,2,1},{2,1,3}};
        System.out.println(new NetworkDelayTime$$SOS().networkDelayTime(times,2,2));
    }
}