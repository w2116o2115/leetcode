package partition;

/**
 * 面试题 10.09. 排序矩阵查找
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int x = 0;
        int y = column-1;
            while (x < row && y >=0){
                if (matrix[x][y] == target) return true;
                if (matrix[x][y] > target) y--;
                else x++;
            }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(new SearchMatrix().searchMatrix(matrix,30));
    }
}