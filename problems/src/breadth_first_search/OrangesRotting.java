package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 */
public class OrangesRotting {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {
        int res = -1;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();
        boolean flag = true;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j] == 2 && !visited[i][j] && flag){
                    flag = false;
                    visited[i][j] = true;
                    queue.offer(null);
                    queue.offer(new int[]{i,j});
                    res = bfs(grid,visited,i,j,queue);
                }
                if (grid[i][j] == 1 && !visited[i][j] && !flag){
                    return -1;
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, boolean[][] visited, int x, int y, Queue<int[]> queue){
        int res = -1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (point == null) {
                if (!queue.isEmpty()) {
                    res += 1;
                    queue.offer(null);
                } else {
                    return res;

                }
            } else {
                x = point[0];
                y = point[1];
                for (int i = 0; i < dir.length; i++) {
                    int xx = x + dir[i][0];
                    int yy = y + dir[i][1];
                    if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length && !visited[xx][yy] && grid[xx][yy] == 1) {
                        visited[xx][yy] = true;
                        queue.offer(new int[]{xx, yy});
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2,1,1},{0,1,1},{1,0,1}};
        System.out.println(new OrangesRotting().orangesRotting(grid));
    }
}