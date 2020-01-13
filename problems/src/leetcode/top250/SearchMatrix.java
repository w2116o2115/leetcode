package leetcode.top250;

import array.Search;

/**
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
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
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] <= target && matrix[i][c - 1] >= target) {
                if (check(0, c - 1, target, matrix[i]))
                    return true;
            }
        }
        return false;
    }

    private boolean check(int left, int right, int target, int[] nums) {
        if (left > right)
            return false;
        int mid = (left + right) >> 1;
        boolean left_check = false;
        boolean right_check = false;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] > target) {
            left_check = check(left, mid - 1, target, nums);
        } else if (nums[mid] < target) {
            right_check = check(mid + 1, right, target, nums);
        }
        return left_check || right_check;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        System.out.println(new SearchMatrix().searchMatrix(matrix,13));
    }
}
