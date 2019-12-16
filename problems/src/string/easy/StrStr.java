package string.easy;

import java.util.Arrays;

/**
 * 28. 实现 strStr()
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {
    public int ViolentMatch(String str1,String str2){
        char[] c1=str1.toCharArray();
        char[] c2=str2.toCharArray();
        int l1=c1.length;
        int l2=c2.length;
        int[] next=new int[l2];
        GetNext(str2,next);
        int i=0,j=0;
        while(i<l1&&j<l2){
            if(j==-1||c1[i]==c2[j]){
                i++;
                j++;
            }else {
                j=next[j];
            }
        }
        if(j==l2){
            return i-j;
        }else {
            return -1;
        }
    }
    public void GetNext(String str2,int[] next){
        char[] c2=str2.toCharArray();
        int l2=c2.length;
        next[0]=-1;
        int k=-1;
        int j=0;
        while (j<l2-1){
            if(k==-1||c2[k]==c2[j]){
                ++k;
                ++j;
                if(c2[j]!=c2[k]){
                    next[j]=k;
                }else {
                    next[j]=next[k];
                }
                //next[j]=k;
            }else {
                k=next[k];
            }
        }
    }

    public static void main(String[] args) {
        int pos=new StrStr().ViolentMatch("abacababc","abab");
        System.out.println(pos);
    }
}
