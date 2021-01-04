package design;

import java.util.Stack;

/**
 * @author carlos zhang
 * @date 2021/1/3 下午1:26
 */
public class 六十二编码 {

    //字符顺序可以乱的，但是由于三位0补全的关系，第一个index必须是'0',
    private static char[]cs = new char[]{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};

    private static String to62(long num10) {
        Stack<Character> stack = new Stack<Character>();
        StringBuffer r = new StringBuffer(0);
        if (num10!=0) {
            long quotient = num10;
            while (quotient!=0) {
                long mod = quotient%62;
                int index = new Long(mod).intValue();
                char c = cs[index];
                stack.add(c);
                quotient=quotient/62;
            }
        }else {
            stack.add(cs[0]);
        }
        while (!stack.isEmpty()) {
            r.append(stack.pop());
        }
        return r.toString();


    }

    private static int get10(char c) {
        for (int i = 0; i < cs.length; i++) {
            if (c == cs[i]) {
                return i;
            }
        }
        return -1;
    }

    private static long to10(String num62) {
        char[] arr = num62.toCharArray();
        int len = arr.length;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            int a = get10(arr[i]);
            if (a == -1) {
                return -1;
            }
            double b = Math.pow(62, len - 1 - i);
            long c = new Double(b).longValue();
            sum += c * a;
        }
        return sum;
    }
    private static String fillZero(String s){
        int size = s.length();
        int dis = 3-size;
        for (int i = 0; i < dis; i++) {
            s="0"+s;
        }
        return s;
    }
    private static String removeZero(String s){
        char[]cs = s.toCharArray();
        StringBuffer r = new StringBuffer(0);
        boolean bool = true;//是0
        for (char c : cs) {
            if (bool) {
                if (c=='0') {
                    continue;
                }else {
                    r.append(c);
                    bool=false;
                }
            }else {
                r.append(c);
            }
        }
        String u = r.toString();
        if (u.equals("")) {
            u="0";
        }
        return u;
    }
    /**
     * 加密
     * @param text
     * @return
     */
    public static String enc(String text){
        StringBuffer sb  = new StringBuffer(0);
        char[]cs = text.toCharArray();
        for (char c : cs) {
            int b = (int)c;
            String d = to62(b);
            String a = fillZero(d);
            sb.append(a);
        }
        return sb.toString();
    }
    /**
     * 解密
     * @param text
     * @return
     */
    public static String dec(String text){
        char[]arr = text.toCharArray();
        StringBuffer r = new StringBuffer(0);
        StringBuffer temp = new StringBuffer(0);
        for (int i = 0; i < arr.length; i++) {

            if ((i+1)%3==0) {
                temp.append(arr[i]);
                String a = temp.toString();
                char cc = (char)to10(removeZero(a));
                r.append(cc);
                temp.setLength(0);
            }else {
                temp.append(arr[i]);
            }
        }
        return r.toString();
    }

    public static void main(String[] args) {
        System.out.println(to62(100000000000L));
    }
}
