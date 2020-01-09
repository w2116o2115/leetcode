package leetcode.top100;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i] == 0){
                for (int j=i;j<nums.length-1;j++){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(1);
    }
}
