package array;

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
 *
 * 思路：一个有四个步骤，左 下 右 上 ，可以用取模的方式锁定防线
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int r = 0;int c = 0;int di = 0;
        for (int i=0;i<n*n;i++){
            res[r][c] = i;
            int rc = dir[di][0];
            int cc = dir[di][1];
            if (rc >=0 && rc < n && cc >=0 && cc <n && res[rc][cc] ==0){
                r = rc;
                c = cc;
            }else {
                di = (di+1)%4;
                r += dir[di][0];
                c += dir[di][1];
            }
        }
        return res;
    }
}
