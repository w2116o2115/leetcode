package tencent;

/**
 * @author carlos zhang
 * @date 2020/7/4 上午11:30
 */
public class ReverseWords {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String str:ss){
            sb.append(rev(str));
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private String rev(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = s.length()-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("Let's take LeetCode contest"));
    }
}
