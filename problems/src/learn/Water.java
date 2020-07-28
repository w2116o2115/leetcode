package learn;

import java.util.Arrays;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2020/7/27 17:56
 */
public class Water {
    public int water(int[] water,int  cnt){
        int res = Integer.MAX_VALUE;

        Arrays.sort(water);
        for (int i=0;i<water.length;i++){
            if ((i - cnt + 1) >= 0){
                int temp = 0;
                for (int x = 1;x<cnt;x++){
                    temp+= (water[i] - water[i-x]);
                }
                res = Math.min(res,temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] water = new int[]{3,1,9 ,10};
        System.out.println(new Water().water(water,3));
    }
}