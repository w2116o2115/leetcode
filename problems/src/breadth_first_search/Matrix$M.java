package breadth_first_search;

import javafx.util.Pair;

import java.util.*;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 */
public class Matrix$M {
  public static class Cell{
    int x;
    int y;

    public Cell(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] temp = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
    int[][] result = new Matrix$M().updateMatrix(temp);
    for (int[] a : result){
        System.out.println(Arrays.toString(a));
    }
  }

  public int[][] updateMatrix(int[][] matrix) {
    int[][] temp = matrix.clone();

    for (int i=0;i<matrix.length;i++){
      for (int j=0;j<matrix[0].length;j++){
        if (matrix[i][j] == 1)
          temp[i][j] = findMinZero(matrix,i,j);
      }
    }
    return temp;
  }

  private int findMinZero(int[][] matrix,int x,int y){
    Queue<Pair<Cell,Integer>> queue = new LinkedList<>();

    Set<String> visited = new HashSet<>();

    queue.add(new Pair<>(new Cell(x,y),0));

    while (!queue.isEmpty()){
      Pair<Cell,Integer> pair = queue.remove();

      if (matrix[pair.getKey().x][pair.getKey().y] == 0)
        return pair.getValue();

      if (!visited.contains(pair.getKey().x + "#" + pair.getKey().y)){
        visited.add(pair.getKey().x + "#" + pair.getKey().y);
        getNextLevl(pair.getKey(),queue,pair.getValue()+1,matrix);
      }
    }
    return matrix[x][y];
  }

  private void getNextLevl(Cell cell,Queue<Pair<Cell,Integer>> queue,Integer level,int[][] matrix) {
    //一个点的上下左右
    if ((cell.x - 1) >= 0)
      queue.add(new Pair<>(new Cell(cell.x-1,cell.y),level));
    if (cell.x + 1 < matrix.length)
      queue.add(new Pair<>(new Cell(cell.x+1,cell.y),level));
    if (cell.y - 1 >= 0)
      queue.add(new Pair<>(new Cell(cell.x,cell.y-1),level));
    if (cell.y + 1 < matrix[0].length)
      queue.add(new Pair<>(new Cell(cell.x,cell.y+1),level));
  }
}
