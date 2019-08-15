package array;

/**
 * 用字符串数组作为井字游戏的游戏板 board。当且仅当在井字游戏过程中，玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。
 *
 * 该游戏板是一个 3 x 3 数组，由字符 " "，"X" 和 "O" 组成。字符 " " 代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符 “X”，且第二个玩家总是放字符 “O”。
 * “X” 和 “O” 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 示例 1:
 * 输入: board = ["O  ", "   ", "   "]
 * 输出: false
 * 解释: 第一个玩家总是放置“X”。
 *
 * 示例 2:
 * 输入: board = ["XOX", " X ", "   "]
 * 输出: false
 * 解释: 玩家应该是轮流放置的。
 *
 * 示例 3:
 * 输入: board = ["XXX", "   ", "OOO"]
 * 输出: false
 *
 * 示例 4:
 * 输入: board = ["XOX", "O O", "XOX"]
 * 输出: true
 */
public class ValidTicTacToeState$M {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    String[] board = {"XXX", "XOO", "OO "};
    System.out.println(new ValidTicTacToeState$M().validTicTacToe(board));
  }

  public boolean validTicTacToe(String[] board) {
    boolean xWon = hasWon(board, 'X');
    boolean oWon = hasWon(board, 'O');
    int xcount = 0, ocount = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[i].charAt(j) == 'X') {
          xcount++;
        } else if (board[i].charAt(j) == 'O') {
          ocount++;
        }
      }
    }
    if (xWon && oWon) return false;
    if (xWon) {
      return ((xcount - 1 == ocount));
    } else if (oWon) {
      return ((xcount == ocount));
    } else {
      return (xcount == ocount || xcount - 1 == ocount);
    }
  }

  private boolean hasWon(String[] board, char c) {
    boolean diagnol =
        ((board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c)
            || (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c));
    if (diagnol) return true;
    for (int i = 0; i < 3; i++) {
      if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c)
        return true;
    }
    for (int i = 0; i < 3; i++) {
      if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c)
        return true;
    }
    return false;
  }
}
