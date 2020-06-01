package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934. 最短的桥
 * <p>
 * 在给定的二维二进制数组 A 中，存在两座岛。（岛是由四面相连的 1 形成的一个最大组。）
 * <p>
 * 现在，我们可以将 0 变为 1，以使两座岛连接起来，变成一座岛。
 * <p>
 * 返回必须翻转的 0 的最小数目。（可以保证答案至少是 1。）
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,1],
 * [1,0]]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[[0,1,0],
 * [0,0,0],
 * [0,0,1]]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[[1,1,1,1,1],
 * [1,0,0,0,1],
 * [1,0,1,0,1],
 * [1,0,0,0,1],
 * [1,1,1,1,1]]
 * 输出：1
 *
 * [[0,1,0,0,0],
 * [0,1,0,1,1],
 * [0,0,0,0,1],
 * [0,0,0,0,0],
 * [0,0,0,0,0]]
 */
public class ShortestBridge {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int row;
    int col;
    boolean[][] visited;
    Queue<int[]> queue = new LinkedList<>();

    public int shortestBridge(int[][] A) {
        row = A.length;
        col = A[0].length;
        visited = new boolean[row][col];
        queue.offer(null);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    break;
                }
            }
        }
        int sum = -1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (point == null) {
                if (queue.isEmpty()) break;
                queue.offer(null);
                sum += 1;
            } else {
                int x = point[0];
                int y = point[1];
                for (int i = 0; i < dir.length; i++) {
                    int xx = x + dir[i][0];
                    int yy = y + dir[i][1];
                    if (xx >= 0 && xx <= A.length - 1 && yy >= 0 && yy <= A[0].length - 1 && !visited[xx][yy] && A[xx][yy] == 1) {
                        return sum;
                    }
                    if (xx >= 0 && xx <= A.length - 1 && yy >= 0 && yy <= A[0].length - 1 && !visited[xx][yy]) {
                        visited[xx][yy] = true;
                        queue.offer(new int[]{xx, yy});
                    }
                }
            }
        }
        return sum;
    }

    private void dfs(int[][] A, int x, int y) {
        if (A[x][y] != 1)
            return;
        if (!visited[x][y]) {
            queue.offer(new int[]{x, y});
            visited[x][y] = true;
        } else {
            return;
        }
        for (int i = 0; i < dir.length; i++) {
            int xx = x + dir[i][0];
            int yy = y + dir[i][1];
            if (xx >= 0 && xx <= A.length - 1 && yy >= 0 && yy <= A[0].length - 1 && !visited[xx][yy])
                dfs(A, xx, yy);
        }
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        System.out.println(new ShortestBridge().shortestBridge(A));
    }
}