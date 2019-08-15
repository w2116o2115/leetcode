package array;

/**
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 *
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 *
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 * 注意:
 *
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 * 数组 A 的长度范围在[1, 50000]。
 *
 * 我是想到了滑动窗口的思想。
 *
 * 标记两个指针 分别为 l , r ，同时指向第一个元素，首先说明一下，滑动窗口的思想，l ， r 指针是只会往后移，
 * 不会回退的。就我目前学到的知识是这样的。如果有错，欢迎大佬们补充。那么问题就来了，该怎么移动？
 *
 * 首先说明一下 l ， r 的意义？ l ， r始终都指向 <=R,的元素的下标。也就是说，可能满足答案，也可能不满足，
 * 但始终比 R 小。 我们分别求得以每个元素为尾的满足要求的子数组的数量，最后把答案累加和一下。
 *
 * 首先l，r 都指向第一个元素，如果此时:
 *
 * L<= A[r] && A[r] <=R, 也就是答案， 那么以当前A[r]结尾以 l 开头的子数组肯定都满足答案。那么总的答案数就是 r-l+1.
 *
 * 如果 A[r] < L ,说明当前只含 A[r] 结尾的子数组（也就是只有 A[r] ）肯定是不满足条件的，但是 有可能以 A[r] 结尾的子数组
 * 的最大值时满足答案的，所以，此时我们应该往左找到第一个 值>=L && 下标>=l ( 防止越界 ) 的下表记为 t ,最差的结果就是找到了
 * l 的位置，所以无论如何都是 值 <=R 的，根据 l 的定义可知。那么结果就是 t - l + 1。
 *
 * 3.否则就是 A[r] > R， 也就是不满足条件。那么如果子数组含有这个值，肯定子数组也不满足条件。所以我们直接跳过这个值，让 l , r 都指向当前值的下一个。
 */
public class SubArraysWithBoundedMaximum$m {
  /**
   * Main method
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] A = {2, 1, 4, 3};
    System.out.println(new SubArraysWithBoundedMaximum$m().numSubarrayBoundedMax(A, 2, 3));
  }

  public int numSubarrayBoundedMax(int[] A, int L, int R) {
    //双指针
    int len = A.length;
    int l=0,r=0;
    int count = 0;
    while (r < len){ //第一种情况
      if (A[r] >= L && A[r] <= R){
        count += r-l+1;
        r++;
      }else if (A[r] < L){//第二种情况
        int t = r - 1;
        while (t>=1 && A[t] < L) t--;
        count += t-l+1;
        r++;
      }else if (A[r] > R){//第三种情况
        r++;
        l = r;
      }
    }
    return count;
  }
}
