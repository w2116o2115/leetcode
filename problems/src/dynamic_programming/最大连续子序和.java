package dynamic_programming;

/**
 * 最大连续子序列和
 * 推导公式 ： dp(i)=max(dp(i-1)+array[i],array[i])
 */
public class 最大连续子序和 {
    /**
     * 推导公式 ： dp(i)=max(dp(i-1)+array[i],array[i])
     */
    private int MaxCountOf(int[] array){
        //max就是上面的dp[i]
        int max = array[0];
        //因为这个dp[i]老是变，所以比如你dp[4]是8 dp[5]就变成-7了，所以需要res保存一下
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 最大连续子序和().MaxCountOf(new int[]{6,-3,-2,7,-15,1,2,2}));
    }
}
