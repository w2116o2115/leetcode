package dynamic_programming;

/**
 * 413. 等差数列划分
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * A = [1, 2, 3, 4]
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 */
public class NumberOfArithmeticSlices$$retry {
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        int res = 0;
        for (int i=2;i<A.length;i++){
            if (A[i]-A[i-1] == A[i-1]-A[i-2]){
                count++;
                res+=count;
            }else {
                count = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfArithmeticSlices$$retry().numberOfArithmeticSlices(new int[]{1,2,3,4}));
    }
}
