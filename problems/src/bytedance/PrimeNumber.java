package bytedance;

/**
 * 输出1000以内的素数
 *
 * @author Carlose wei
 * @version 1.0
 * @date 2020/9/14 15:56
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int i,j;
        for(i=1;i<=1000;i++){
            if(i==1 || i==2){
                System.out.println(i);
                continue;
            }
            for(j=2;j<i;j++){
                if(i%j==0)
                    break;
                if(j==i-1)
                    System.out.println(i);
            }
        }
    }
}