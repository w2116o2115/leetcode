package array;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if (r == 0) return false;
        int c = matrix[0].length;
        if (c == 0) return false;
        //首先找出行
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] <= target && matrix[i][c - 1] >= target) {
                return search(matrix[i],target);
            }
        }
        return false;
    }

    private boolean search(int[] nums,int target){
        int l = 0;
        int r = nums.length-1;
        while (l<=r){
            int mid = l+r>>1;
            if (nums[mid] == target)
                return true;
            if(nums[mid] > target){
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,   3}};
        System.out.println(new SearchMatrix().searchMatrix(matrix,3));
    }
}