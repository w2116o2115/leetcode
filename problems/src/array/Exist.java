package array;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 同一个单元格内的字母不允许被重复使用。

  

 示例:

 board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 给定 word = "ABCCED", 返回 true
 给定 word = "SEE", 返回 true
 给定 word = "ABCB", 返回 false
 */
public class Exist {
    int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

    public boolean exist(char[][] board, String word) {
        char[] cc = word.toCharArray();
        if (cc.length == 0)
            return false;
        boolean[][] flag;
        int r = board.length;
        int c = board[0].length;
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (board[i][j] == cc[0]){//找到了第一个单词
                    flag = new boolean[board.length][board[0].length];
                    if (bfs(i,j,board,cc,1,flag)) return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(int i,int j,char[][] board,char[] cc,int index,boolean[][] flag){
        if (index == cc.length) return true;
        for (int[] aDir : dir) {
            int r = i + aDir[0];
            int c = j + aDir[1];
            flag[i][j] = true;
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == cc[index]&&!flag[r][c] && bfs(r, c, board, cc, index + 1,flag))
                return true;
            flag[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'C','A','A'},
                                      {'A','A','A'},
                                      {'B','C','D'}};
        System.out.println(new Exist().exist(board,"AAB"));
    }
}
