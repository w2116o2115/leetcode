package breadth_first_search;

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
 *
 * 思路： 先从边上找0
 */
public class Solve {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int row = board.length;
        int col = board[0].length;
        for (int i=0;i<row;i++){
            if (board[i][0] == '0') visited(visited,board,i,0);
            if (board[i][col-1] == '0') visited(visited,board,i,col-1);
        }

        for (int i=0;i<col;i++){
            if (board[0][i] == '0') visited(visited,board,0,i);
            if (board[row-1][i] == '0') visited(visited,board,col-1,i);
        }

        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (!visited[i][j] && board[i][j] == '0')
                    board[i][j] = 'X';
            }
        }
    }

    private void visited(boolean[][] visited,char[][] board,int row,int col){
        if (row<0 || col<0|| row >= board.length || col >= board[0].length || board[row][col] == 'X')
            return;
        visited[row][col] = true;
        for (int i=0;i<4;i++){
            int RR = row + dir[i][0];
            int CC = col + dir[i][1];
            visited(visited,board,RR,CC);
        }
    }
}