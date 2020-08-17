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
        int max = array[0];
        for (int i=1;i<array.length;i++){
            max = Math.max(max+array[i],array[i]);
            array[i] = Math.max(array[i-1],max);
        }
        return array[array.length-1];
    }

    public static void main(String[] args) {
        System.out.println(new 最大连续子序和().MaxCountOf(new int[]{6,-3,-2,7,-15,1,2,2}));
    }
}
