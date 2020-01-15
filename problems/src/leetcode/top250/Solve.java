package leetcode.top250;

/**
 * 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 *
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *
 * 示例:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 *
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 */
public class Solve {
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

    public void solve(char[][] board) {
        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        for (int i=0;i<r;i++){
            if (board[0][i] == '0') viste(0,i,visited,board);
            if (board[r-1][i] == '0') viste(r-1,i,visited,board);
        }
        for (int i=0;i<c;i++){
            if (board[i][0] == '0') viste(i,0,visited,board);
            if (board[i][c-1] == '0') viste(i,c-1,visited,board);
        }

        for (int i=1;i<r-1;i++){
            for (int j=1;j<c-1;j++){
                if (board[i][j]=='0' && !visited[i][j]) board[i][j] = 'X';
            }
        }
    }

    private void viste(int i,int j,boolean[][] visited,char[][] board){
        if (i<0||i>=visited.length||j<0||j>=visited[0].length&&board[i][j]=='X'||visited[i][j])
            return;
        visited[i][j] = true;
        for (int di=0;j<dir.length;j++){
            i+=dir[di][0];
            j+=dir[di][1];
            viste(i,j,visited,board);
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X','X','X','X'},{'X','0','0','X'},{'X','X','0','X'},{'X','0','X','X'}};
        new Solve().solve(board);
        System.out.println(1);
    }
}
