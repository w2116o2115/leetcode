package string;

/**
 * 0 1 2 3 4
 * 6. Z 字形变换
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/20 11:08
 */
public class Convert {
    public String convert(String s, int numRows) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (i%numRows == 0){
                s1.append(s.charAt(i));
            }else if (i%numRows == 1){
                s2.append(s.charAt(i));
            }else if (i%numRows == 2){
                s3.append(s.charAt(i));
            }
        }
        return s1.append(s2).append(s3).toString();
    }

    public static void main(String[] args) {
        new Convert().convert("LEETCODEISHIRING",3);
    }
}
