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
    for (int i = 0;i< board.length;i++){
      for (int j = 0;j<board[0].length;j++){
        if (board[i][j] == word.charAt(0))
            if (search(i,j,word,board,1)) return true;
      }
    }
    return false;
  }

  private boolean search(int i,int j,String word,char[][] board,int wordIndex){
    if (wordIndex > word.length()-1) {
      isOk = true;
      return isOk;
    }
    if (i+1 < board.length && board[i+1][j] == word.charAt(wordIndex)){
      if (!map.contains(i+1 + "#" + j))
        map.add(i+1 + "#" + j);
        search(i+1,j,word,board,wordIndex+1);
    }else if (i-1 >=0 &&board[i-1][j] == word.charAt(wordIndex)){
      if (!map.contains(i-1 + "#" + j))
        map.add(i-1 + "#" + j);
        search(i-1,j,word,board,wordIndex+1);
    }else if (j+1 < board[0].length  && board[i][j+1] == word.charAt(wordIndex)){
      if (!map.contains(i + "#" + (j+1)))
        map.add(i + "#" + (j+1));
        search(i,j+1,word,board,wordIndex+1);
    }else if (j-1 >= 0 && board[i][j-1] == word.charAt(wordIndex)){
      if (!map.contains(i + "#" + (j-1)))
        map.add(i + "#" + (j-1));
        search(i,j-1,word,board,wordIndex+1);
    }
    return isOk;
  }
}
