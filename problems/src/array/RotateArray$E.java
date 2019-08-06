package array;

/**
 今天介绍的是LeetCode算法题中Easy级别的第43题（顺位题号是189）。给定一个数组，将数组向右旋转k步，其中k为非负数。例如：

 输入：[1,2,3,4,5,6,7]，k = 3
 输出：[5,6,7,1,2,3,4]
 说明：
 向右旋转1步：[7,1,2,3,4,5,6]
 向右旋转2步：[6,7,1,2,3,4,5]
 向右旋转3步：[5,6,7,1,2,3,4]

 输入：[ - 1，-100,3,99]，k = 2
 输出：[3,99，-1，-100]
 说明：
 向右旋转1步：[99，-1，-100,3]
 向右旋转2步：[3,99，-1，-100]

 先通过一个小例子来说明：

 nums = {1,2,3,4,5,6,7}，k = 3，

 先反转其全部元素，变成{7,6,5,4,3,2,1}

 再反转前3个元素，变成{5,6,7,4,3,2,1}

 再反转后4个元素，变成{5,6,7,1,2,3,4}

 这样就能够得到答案了。
 */
public class RotateArray$E {
  /**
   * Main method
   *
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {
    int[] A = {1, 2, 3, 4, 5, 6};
    new RotateArray$E().rotate(A, 2);
    for (int i : A) System.out.print(i + " ");
  }

  public void rotate(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  private void reverse(int[] nums, int s, int e) {
    for (int i=s,j=e;i < j;i++,j--){
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }
}
