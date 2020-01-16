package backtracking;

/**
 * 8皇后
 * @author Carlose wei
 * @version 1.0
 * @date 2020/1/2 12:46
 */
public class Cal8queens {

    int[] result = new int[8];//全局或成员变量,下标表示行,值表示queen存储在哪一列
    public void cal8queens(int row) { // 调用方式：cal8queens(0);
        if (row == 8) { // 8个棋子都放置好了，打印结果
            printQueens(result);
            return; // 8行棋子都放好了，已经没法再往下递归了，所以就return
        }
        for (int column=0;column<8;column++){
            if (isOk(row,column)){
                result[row] = column;
                cal8queens(row+1);
            }
        }
    }

    private boolean isOk(int row, int column) {//判断row行column列放置是否合适
        int left_up = column - 1;int right_up = column + 1;
        for (int i=row-1;i>=0;i--){
            if (result[i] == column) return false;
            if (left_up > 0)
                if (result[i] == left_up) return false;
            if (right_up < 8)
                if (result[i] == right_up) return false;
            left_up--;
            right_up++;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Cal8queens().cal8queens(0);
    }
}
