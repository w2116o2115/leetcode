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
 * 思路：1. 由右往左 找第一个 第一个前边的数字比后边的数字小 1 2 5 8 7  ，就找到了5
 *      2. 从右往左找第一个比它大的数字，7 比 5大 ，就找到了7
 *      3. 调换 5 和 7， 1 2 7 8 5 ，然后7后边的的数字要调换一下  1 27 5 8
 *
 */
public class NextPermutation$$retry {
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
        new NextPermutation$$retry().nextPermutation(new int[]{1,3,2});
    }
}
