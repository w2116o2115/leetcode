package dynamic_programming.背包九讲;

import java.util.Scanner;

/**
 * 题目
 * 有N种物品和一个容量为V的背包，每种物品都有无限件可用。第i种物品的体积是c[i]，价值是w[i]。求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 */
public class B完全背包问题 {
    void run(){
        int n = jin.nextInt();
        int m = jin.nextInt();

        for (int i = 1 ; i <= n ; i++){
            v[i] = jin.nextInt();
            w[i] = jin.nextInt();
        }
        int res = dp(n, m);
        // int res = dp2(n, m);
        System.out.println(res);
    }

    int dp(int n, int m){
        int[] f= new int[maxN];

        for (int i = 1 ;  i <= n; i++){
            for (int j = v[i]; j<= m ; j++){
                // 计算了从0~m 的所有体积转移的可能结果，所以不用再每次枚举选第i个物品几个
                // 直接对应了每个物品可选无限次
                f[j] = Math.max(f[j], f[j-v[i]] + w[i]);
            }
        }
        return f[m];
    }

    int dp2(int n , int m){
        int[] f = new int[maxN];

        for (int i = 1 ; i <= n ; i++){
            for (int j = m ; j >= v[i] ; j--){
                for (int k = 0 ;k * v[i] <= j ; k++){  // 转化为01 背包 + 无限选的做法
                    f[j] = Math.max(f[j], f[j-k*v[i]] + k*w[i]);
                }
            }
        }
        return f[m];

    }


    int maxN = 1002;
    int[] v = new int[maxN];
    int[] w = new int[maxN];
    Scanner jin = new Scanner(System.in);
    public static void main(String[] args) throws Exception {new B完全背包问题().run();}
}