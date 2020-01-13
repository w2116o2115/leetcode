package leetcode.top250;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class SetZeroes {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        Set<Integer> setR = new HashSet<>();
        Set<Integer> setC = new HashSet<>();

        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if (matrix[i][j] == 0) {
                    setR.add(i);
                    setC.add(j);
                }
            }
        }

        for (int x=0;x<r;x++){
            if (setR.contains(x)){
                for (int i=0;i<c;i++){
                    matrix[x][i] = 0;
                }
            }
        }

        for (int y=0;y<c;y++){
            if (setC.contains(y)){
                for (int i=0;i<r;i++){
                    matrix[i][y] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        new SetZeroes().setZeroes(matrix);
        System.out.println(1);
    }
}
