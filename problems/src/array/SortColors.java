package array;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]

 */
public class SortColors {
    public void sortColors(int[] nums) {
        quickSort(0,nums.length-1,nums);
    }

    private void quickSort(int l,int r,int[] nums){
        if (l>r)
            return;
        int left = l;
        int right = r;
        int sentry = nums[l];
        while (left < right){
            while (left<right && nums[right] >= sentry){
                right--;
            }
            while (left<right && nums[left] <= sentry){
                left++;
            }
            if (left < right){
                int t = nums[left];
                nums[left] = nums[right];
                nums[right] = t;
            }
        }
        nums[l] = nums[left];
        nums[left] = sentry;
        quickSort(l,left-1,nums);
        quickSort(left+1,r,nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        new SortColors().sortColors(nums);
        System.out.println(1);
    }
}