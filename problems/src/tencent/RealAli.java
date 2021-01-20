package tencent;

/**
 * 1 2 6 7 15...
 * 3 5 8 14...
 * 4 9 13...
 * 10 12...
 * 11...
 * 奇数行的末位为n(n+1)/2
 * 偶数行的首位为n(n+1)/2
 *
 * 第1排有1个数1,前1排有1个数
 * 第2排有2个数3,2,前2排有3个数
 * 第3排有3个数4,5,6,前3排有6个数
 */
public class RealAli {
    public static int getValue(int x,int y){
        int c = x+y+1;
        System.out.println((c)*(c+1)/2);
        int res = c*(c+1)/2;
        while (y-->0){
            res--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getValue(2,1));
    }
}