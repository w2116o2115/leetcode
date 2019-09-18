package depth_first_search;

/**
 * 1020. 飞地的数量
 *
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 *
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 *
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[0,0,0,0],
 *       [1,0,1,0],
 *       [0,1,1,0],
 *       [0,0,0,0]]
 * 输出：3
 * 解释：
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 *
 * 输入：[[0,1,1,0],
 *       [0,0,1,0],
 *       [0,0,1,0],
 *       [0,0,0,0]]
 * 输出：0
 * 解释：
 * 所有 1 都在边界上或可以到达边界。
 *
 * 思路  把以四个边为起点的1 全部变成0  然后遍历上下图中的1
 */
public class NumEnclaves {
    private boolean isLand = false;
    private int num;

    public int numEnclaves(int[][] A) {
        if (A == null || A.length == 0)
            return 0;
        int nr = A.length;
        int nc = A[0].length;
        int max = 0;
        for (int r = 0;r<nr;r++){
            for (int c = 0;c < nc; c++){
                if (A[r][c] == 1) {
                    dfs(A, r, c);
                    if (isLand) {
                        isLand = false;
                        num = 0;
                    } else {
                        max = Math.max(max,num);
                    }
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid,int r,int c){
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc) {
            isLand = true;
            return;
        }

        if (grid[r][c] == 0)
            return;

        num++;
        grid[r][c] = 0;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(new NumEnclaves().numEnclaves(A));
    }
}
