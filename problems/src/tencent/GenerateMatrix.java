package tencent;

/**
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class GenerateMatrix {
    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int di = 0;
        int x = 0;int y = 0;
        for (int i=1;i<=n*n;i++){
            res[x][y] = i;
            int xx = x+dir[di][0];
            int yy = y+dir[di][1];
            if (xx >=0 && yy >=0 && xx < n && yy < n && res[xx][yy] ==0){
                x = xx;
                y = yy;
            }else {
                di = (di+1)%4;
                x = x+dir[di][0];
                y = y+dir[di][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = new GenerateMatrix().generateMatrix(3);
        System.out.println(1);
    }
}