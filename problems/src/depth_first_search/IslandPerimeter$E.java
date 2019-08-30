package depth_first_search;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *  
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class IslandPerimeter$E {

  int[] R = {1, -1, 0, 0};
  int[] C = {0, 0, 1, -1};
  boolean[][] done;
  int perimeter;
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
    System.out.println(new IslandPerimeter$E().islandPerimeter(grid));
  }

  public int islandPerimeter(int[][] grid) {
    done = new boolean[grid.length][grid[0].length];
    perimeter = 0;
    for (int i=0;i<grid.length;i++){
      for (int j=0;j<grid[0].length;j++){
        if (grid[i][j] == 1 && !done[i][j])
          dfs(i,j,grid);
          break;
      }
    }
    return perimeter;
  }

  private void dfs(int r, int c, int[][] grid) {
    done[r][c] = true;
    for (int i=0;i<4;i++){
      int newR = r + R[i];
      int newC = c + C[i];
      if (newC < 0 || newR < 0 || newR >= grid.length || newC >= grid[0].length){
        perimeter++;
      }else if (grid[newR][newC] == 0){
        perimeter++;
      }else {
        if (!done[newR][newC]){
          dfs(newR,newC,grid);
        }
      }
    }
  }
}
