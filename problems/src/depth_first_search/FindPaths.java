package depth_first_search;

/**
 * 576. 出界的路径数
 * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。
 * 但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
 *
 * 示例 1：
 *
 * 输入: m = 2, n = 2, N = 2, i = 0, j = 0
 * 输出: 6
 */
public class FindPaths {
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int res = 0;

    public int findPaths(int m, int n, int N, int i, int j) {
        boolean[][] visited = new boolean[m][n];
        dfsHelper(m,n,i,j,N,visited);
        return res;
    }

    private void dfsHelper(int m,int n,int x,int y,int N,boolean[][] visited){
        if (N == 0)
            return;
        N--;
        for (int i = 0;i<dir.length;i++){
            int xx = x+dir[i][0];
            int yy = y+dir[i][1];
            if (xx < 0 || xx >= m || yy< 0 || yy >=n){
                res++;
                continue;
            }
            if (!visited[xx][yy]){
                visited[xx][yy] = true;
                dfsHelper(m,n,xx,yy,N,visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindPaths().findPaths(2,2,2,0,0));
    }
}