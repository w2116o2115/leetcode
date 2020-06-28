package dynamic_programming.unboundedKnapsack;

/**
 *  B完全背包问题
 *
f[i][v]:前i件物品放入背包容量为v的背包获得的最大收益
f[i][v] = max(f[i - 1][v],f[i - 1][v - k * Wi] + k * Vi,其中 1<=k<= v/Wi)
边界条件
f[0][v] = 0;
f[i][0] = 0;
*/
public class CompleteBackpack {
    private static final int N = 3;
    private static final int V = 5;
    private int weight[] = {0,3,2,2};
    private int Value[] = {0,5,10,20};
    private int f[][]=new int[N+1][V+1];

    public int Completeknapsack()
    {
        //边界条件，第0行和第0列的值设为0
        for (int i = 0;i <= N;i++){
            f[i][0] = 0;
        }
        for (int v = 0;v <= V;v++){
            f[0][v] = 0;
        }
        //递推
        for (int i = 1;i <= N;i++){
            for (int v = 1;v <= V;v++){
                f[i][v] = 0;
                int nCount = v / weight[i];  //最多可以放nCount个物品i
                //和01背包的区别就在这里，01背包只有两种状态：放与不放
                //而完全背包可以放0到k个物品i，同样是取最大值
                for (int k = 0;k <= nCount;k++){
                    f[i][v] = Math.max(f[i][v],f[i - 1][v - k * weight[i]] + k * Value[i]);
                }
            }
        }
        return f[N][V];
    }
    public static void main(String[] args) {
        System.out.println(new CompleteBackpack().Completeknapsack());

    }
}
