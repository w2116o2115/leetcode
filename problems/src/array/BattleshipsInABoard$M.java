package array;

/**
 * 给定一个2维板，计算其中包含多少艘不同的战舰。战舰用字符'X'表示，空白槽位用'.'表示。你应该假设如下规则：
 *
 * 给定的板子是有效的，只包含战舰和空白槽位。
 * 战舰只能水平或者竖直放置。
 * 战舰的尺寸可能不同。
 * 两艘战舰之间在水平方向或者竖直方向至少包含一个空间—不会存在相邻的战舰。
 * Example:
 *
 * X..X
 * ...X
 * ...X
 */
public class BattleshipsInABoard$M {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    char[][] board = {{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}};
    System.out.println(new BattleshipsInABoard$M().countBattleships(board));
  }

  public int countBattleships(char[][] board) {
    int count = 0;
    for (int i=0;i<board.length;i++){
      for (int j=0;j< board[0].length;j++){
        if (board[i][j] == 'X'){
          if (i-1 >= 0 && board[i-1][j] == 'X') continue;
          if (j-1 >= 0 && board[i][j-1] == 'X') continue;
          count++;
        }
      }
    }
    return count;
  }
}
