package leetcode.top100;

/**
 * 739. 每日温度
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 思路：当前我们需要计算 7575 位置，然后向右遍历到 7171，因为我们已经计算好了 7171 位置对应的值为 22，那么我们就可以直接跳 22 为在进行比较，利用了已经有的结果，减少了遍历的次数。
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i=T.length-1;i>=0;i--){
            for (int j=i+1;j<T.length;j++){
                if (T[j] < T[i]){
                    j+=res[j];
                }
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
                res[i] = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new DailyTemperatures().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(1);
    }
}
