package array;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 思路：1.从左到右找出第二大的数的索引，如果没有直接反转 nums[k] < num[k+1]
 *      2. 找出比k更大的数字索引然后交换
 *      3. 反转 k+1以后的数字，保证第二小
 *
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int firstIndex = -1;
        for (int i=nums.length-2;i>=0;i--){
            if (nums[i] < nums[i+1]){
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1){
            rev(nums,0,nums.length-1);
            return;
        }

        int secondIndex = -1;
        for (int i=nums.length-1;i>=0;i--){
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        sweap(nums,firstIndex,secondIndex);
        rev(nums,firstIndex+1,nums.length-1);
        return;
    }

    private void rev(int[] nums,int start,int end){
        while (start<end){
            sweap(nums,start++,end--);
        }
    }

    private void sweap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
     }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1,3,2});
    }
}
