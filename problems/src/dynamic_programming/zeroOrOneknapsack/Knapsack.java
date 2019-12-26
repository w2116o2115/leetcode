package dynamic_programming.zeroOrOneknapsack;

import java.util.Scanner;


/**
 * 01背包问题 将重量为(w1,w2,w3,w4,w5...)、价值为(v1,v2,v3,v4,v5...)的物品放入容量为N的背包中，怎样放价值最大
 * 动态规划：
 * 我们设v[i][j]为放入前i个物品到容量为j的背包中的最大值，i一定是小于物品总个数的，j一定是小于N的
 * 举个例子 v[2][5]表示将前两个物品放入容量为5的背包中的最大价值 v[2][6]表示将前两个物品放入容量为6的背包中的最大价值
 * 则有等式：
 * v[0][j] = v[j][0] = 0
 * v[i][j] = v[i-1][j] w[i]>j
 * v[i][j] = Max(v[i-1][j],v[i-1][j-w[i]]+value[i]) w[i] <= j
 * 暴力求解：
 * 求出物品个数的所有子集，计算每一个子集的价值，选出最大值
 * 例如有4个物品，那么2^4=16个子集，每个子集有四位，每一位是0代表该子集中没有该物品，是1代表有该物品
 * 0 0 0 0 代表该子集中没有任何物品
 * 0 1 0 1 代表该子集中有2号物品和4号物品
 */
public class Knapsack {
    static int[] w = new int[6];//每件物品的重量
    static int[] v = new int[6];//每件物品的价值
    public static void solution(){


        int[][] temp = new int[6][9];//8表示背包最多能放8公斤的重量
        for(int j = 0;j < 9;j++){//初始化每一行
            temp[0][j] = 0;
        }
        for(int i = 1;i < 6;i++){//背包重量为0时，最大价值肯定是0
            temp[i][0] = 0;
        }

        for(int i = 1;i < 6;i++){//从第一个物品开始选，记录我选了前面出现的物品，背包重量从1-8的能选上的最大值
            for(int j = 1;j < 9;j++){//当i循环到最后一层5的时候，也就是得到了，我5件物品都选上的时候的最大值
                if(w[i] <= j){//重量比这个状态小，那么就能放。就是放与不放的问题，观察室放重量大还是不放重量大
                    temp[i][j] = Math.max(temp[i-1][j], temp[i-1][j-w[i]]+v[i]);
                }else{
                    temp[i][j] = temp[i-1][j];//第i件物品不能放
                }
            }
        }
        for(int i = 0;i < 6;i++){
            for(int j = 0;j < 9;j++){
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("请依次输入重量和价值:");
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            w[i] = scn.nextInt();//输入重量
            v[i] = scn.nextInt();//输入价值
        }
        solution();
    }
}
