package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 *
 * 方法三：双指针
 *
 * 首先对数组排序。
 * 固定最长的一条边，运用双指针扫描
 * 如果 nums[l] + nums[r] > nums[i]，同时说明 nums[l + 1] + nums[r] > nums[i], ..., nums[r - 1] + nums[r] > nums[i]，
 * 满足的条件的有 r - l 种，r 左移进入下一轮。
 * 如果 nums[l] + nums[r] <= nums[i]，l 右移进入下一轮。
 */
public class TriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    --r;
                }else {
                    ++l;
                }
            }
        }
        return res;
    }

//    public void backtrack(int[] nums, int index, Stack<Integer> temp){
//        if (temp.size() == 3){
//            List stack = new ArrayList(temp);
//            if (isOk(stack)) res++;
//            return;
//        }
//
//        for (int i=index;i<nums.length;i++){
//            temp.push(nums[i]);
//            backtrack(nums,i+1,temp);
//            temp.pop();
//        }
//    }
//
//    private boolean isOk(List<Integer> temp){
//        int a = temp.get(0);
//        int b = temp.get(1);
//        int c = temp.get(2);
//        return a + b > c && a + c > b && b + c > a;
//    }

    public static void main(String[] args) {
        System.out.println(new TriangleNumber().triangleNumber(new int[]{2,2,3,4}));
    }
}
