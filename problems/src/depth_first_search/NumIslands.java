package depth_first_search;

/**
 * 200. 岛屿数量
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 算法
 * 线性扫描整个二维网格，如果一个结点包含 1，则以其为根结点启动深度优先搜索。
 * 在深度优先搜索过程中，每个访问过的结点被标记为 0。计数启动深度优先搜索的根结点的数量，即为岛屿的数量。。
 */
public class NumIslands {
    private void dfs(char[][] grid,int r,int c){
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int nr = grid.length;
        int nc = grid[0].length;
        int land_num = 0;
        for (int i=0;i<nr;i++){
            for (int j=0;j<nc;j++){
                if (grid[i][j] == '1')
                    land_num++;
                    dfs(grid,i,j);

            }
        }
        return land_num;
    }
}
