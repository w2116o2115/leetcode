package top100;

/**
 * 75. 颜色分类
 *
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
    public static void sortColors(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    private static void quickSort(int[] nums,int left,int right){
        int i,j,t,temp;
        if (left > right){
            return;
        }
        i = left;
        j = right;
        temp = nums[left];
        while (i!=j){
            while (i<j && nums[j]>=temp){
                j--;
            }
            while (i<j && nums[i] <= temp){
                i++;
            }
            if (i<j){
                t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[left] = nums[i];
        nums[i] = temp;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(1);
    }
}
