package backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class WordSearch$M {
  private static final Set<String> map = new HashSet<>();
  private static boolean isOk = false;
  private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
  // 盘面上有多少行
  private int m;
  // 盘面上有多少列
  private int n;
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    System.out.println(new WordSearch$M().exist(board, "ABCB"));
  }

  private boolean exist(char[][] board,String word){
    m = board.length;
    if (m == 0) {
      return false;
    }
    n = board[0].length;
    for (int i = 0;i< board.length;i++){
      for (int j = 0;j<board[0].length;j++){
        if (board[i][j] == word.charAt(0)) {
          if (search(i, j, word, board, 0,new boolean[m][n])) return true;
        }
      }
    }
    return false;
  }

  private boolean search(int x,int y,String word,char[][] board,int wordIndex,boolean[][] maked){
    if (wordIndex == word.length()-1)
      return board[x][y] == word.charAt(wordIndex);
    if (board[x][y] == word.charAt(wordIndex)){
      maked[x][y] = true;
      for (int[] dir:direction){
        int xx = x+dir[0];
        int yy = y+dir[1];
        if (inArea(xx,yy) && !maked[xx][yy])
          if (search(xx,yy,word,board,wordIndex+1,maked)) return true;
      }
      maked[x][y] = false;
    }
    return false;
  }

  private boolean inArea(int x, int y) {
    return x >= 0 && x < m && y >= 0 && y < n;
  }
}
