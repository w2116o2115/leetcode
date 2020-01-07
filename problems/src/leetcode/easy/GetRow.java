package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class GetRow {
    public List<Integer> getRow(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i=1;i<=rowIndex;i++){
            for (int j=1;j<i;j++){
                int temp = cur.get(j);
                cur.set(j,pre+cur.get(j));
                pre = temp;
            }
            cur.add(1);
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new GetRow().getRow(3));
    }
}
