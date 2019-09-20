package depth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934. 最短的桥
 *
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 *
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 *
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[0,1],
 *       [1,0]]
 * 输出：1
 * 示例 2：
 *
 * 输入：[[0,1,0],
 *       [0,0,0],
 *       [0,0,1]]
 * 输出：2
 * 示例 3：
 *
 * 输入：[[1,1,1,1,1],
 *       [1,0,0,0,1],
 *       [1,0,1,0,1],
 *       [1,0,0,0,1],
 *       [1,1,1,1,1]]
 * 输出：1
 *
 * 我们通过对数组 A 中的 1 进行深度优先搜索，可以得到两座岛的位置集合，分别为 source 和 target。
 * 随后我们从 source 中的所有位置开始进行广度优先搜索，当它们到达了 target 中的任意一个位置时，搜索的层数就是答案。
 */
public class ShortestBridge {
    private int[][] id;
    private Queue<int[]> queue;

    public int shortestBridge(int[][] A) {
        int m = A.length, n = A[0].length;
        id = new int[m][n];
        queue = new LinkedList<>();
        int island = 0, ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1 && id[i][j] == 0) {
                    dfs(A, i, j, ++island);
                }
            }
        }
        while (!queue.isEmpty()) { // 一层一层的搜索
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] idx = queue.poll();
                int i = idx[0], j = idx[1];
                if (i > 0) {
                    if (A[i - 1][j] == 0) {
                        A[i - 1][j] = 1;
                        queue.offer(new int[]{i - 1, j});
                    } else if (id[i - 1][j] == 2) return ans;
                }
                if (j > 0) {
                    if (A[i][j - 1] == 0) {
                        A[i][j - 1] = 1;
                        queue.offer(new int[]{i, j - 1});
                    } else if (id[i][j - 1] == 2) return ans;
                }
                if (i < A.length - 1) {
                    if (A[i + 1][j] == 0) {
                        A[i + 1][j] = 1;
                        queue.offer(new int[]{i + 1, j});
                    } else if (id[i + 1][j] == 2) return ans;
                }
                if (j < A[0].length - 1) {
                    if (A[i][j + 1] == 0) {
                        A[i][j + 1] = 1;
                        queue.offer(new int[]{i, j + 1});
                    } else if (id[i][j + 1] == 2) return ans;
                }
            }
            ans++;
        }
        return ans;
    }

    private void dfs(int[][] A, int i, int j, int island) {
        if (A[i][j] == 0 || id[i][j] != 0) return;
        id[i][j] = island;

        if (island == 1)
            queue.offer(new int[]{i, j});
        if (i > 0)
            dfs(A, i - 1, j, island);
        if (j > 0)
            dfs(A, i, j - 1, island);
        if (i < A.length - 1)
            dfs(A, i + 1, j, island);
        if (j < A[0].length - 1)
            dfs(A, i, j + 1, island);
    }

    public static void main(String[] args) {
        System.out.println(new ShortestBridge().shortestBridge(new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}}));
    }
}
