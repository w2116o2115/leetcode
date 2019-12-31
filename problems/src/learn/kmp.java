package learn;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2019/12/31 14:02
 */
public class kmp {
    public static int kmp(char[] a,int n,char[] b,int m){
        int[] next = getNexts(b,m);
        int j = 0;
        for (int i=0;i<n;i++){
            while (j>0 && a[i] != b[i]){
                j = next[j-1]+1;
            }
            if (a[i] == b[i]){
                j++;
            }
            if (j == m){
                return  i-m+1;
            }
        }
        return -1;
    }


    // b表示模式串，m表示模式串的长度
    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i=1;i<m;i++){
            while (k!=-1 && b[k+1] != b[i]){
                k = next[k];
            }
            if (b[k+1] == b[i]){
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        char[] m = new char[]{'a','b','a','b','a','c','d'};
        int[] next = getNexts(m,m.length);
        System.out.println(1);
    }
}
