package array;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题  只能遍历一次。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 *
 * 关键点：用two pointers，一头一尾放置红色和蓝色，保留白色在中间
 */
public class SortColors$M {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] nums = {2, 1, 0, 0, 1};
    new SortColors$M().sortColors(nums);
    for (int i : nums) System.out.println(i);
  }

  public void sortColors(int[] nums) {
    int red = 0;
    int blud = nums.length - 1;
    for (int i=0;i<=blud;i++){
      if (nums[i] == 0){
        int temp = nums[red];
        nums[red] = nums[i];
        nums[i] = temp;
        red ++;
      }else if (nums[i] == 2){
        int temp = nums[blud];
        nums[blud] = nums[i];
        nums[i] = temp;
        blud--;
        i--;
      }
    }
  }
}
