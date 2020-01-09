package leetcode.top100;

import java.util.*;

/**
 * 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    private void bankTrack(List<List<Integer>> res, int index, Stack<Integer> queue,int[] nums,Set<String> set){
        if (queue.size() == 3){
            List<Integer> list = new ArrayList<>(queue);
            System.out.println(list);
            int sum = 0;
            String s = "";
            for (Integer num:list){
                s += String.valueOf(num);
                sum += num;
            }
            if (sum == 0 && !set.contains(s)) {
                res.add(new ArrayList<>(queue));
                set.add(s);
            }
        }

        for (int i=index;i<nums.length;i++){
            queue.add(nums[i]);
            bankTrack(res,++index,queue,nums,set);
            queue.pop();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        bankTrack(res,0,new Stack<>(),nums,new HashSet<>());
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
