package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        generateHelper(1,numRows,res,new ArrayList<>());

        return res;
    }

    private void generateHelper(int index,int numRows,List<List<Integer>> res,List<Integer> list){
        if (index > numRows)
            return;
        if (index == 1 || index == 2){
            List<Integer> newList = new ArrayList<>();
            if (index == 1) {
                newList.add(1);
            }else {
                newList.add(1);
                newList.add(1);
            }
            res.add(newList);
            generateHelper(index+1,numRows,res,newList);
        }else {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int i=0;i<list.size()-1;i++){
                newList.add(list.get(i)+list.get(i+1));
            }
            newList.add(1);
            res.add(newList);
            generateHelper(index+1,numRows,res,newList);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Generate().generate(5));
    }
}
