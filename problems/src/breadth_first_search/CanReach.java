package breadth_first_search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1306. 跳跃游戏 III
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 *
 * 请你判断自己是否能够跳到对应元素值为 0 的 任意 下标处。
 *
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 *
 * 示例 1：
 *
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 */
public class CanReach {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] used  = new boolean[arr.length];
        while (!queue.isEmpty()){
            Integer i = queue.poll();
            int num1 = i+ arr[i];
            int num2 = i- arr[i];
            if (num1 >= 0 && num1 < arr.length && !used[num1]) {
                if (arr[num1] == 0) return true;
                queue.offer(num1);
                used[num1] = true;
            }
            if (num2 >= 0 && num2 < arr.length && !used[num2]) {
                if (arr[num2] == 0) return true;
                queue.offer(num2);
                used[num2] = true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0};
        System.out.println(new CanReach().canReach(arr,0));
    }
}