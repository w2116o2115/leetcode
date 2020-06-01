package breadth_first_search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 *
 * 思路： 广度优先遍历， 顺时针和逆时针同事进行， 转到没得转为止，碰到dead直接返回，遇见的第一个target即为最小步数
 */
public class OpenLock$$SOS {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<String>();
        // 记录已走路径
        Set<String> visited = new HashSet<>();
        // 原数组不易判断，转为set集合
        Set<String> deadList = new HashSet<>();
        // 记录步数
        int step = 0;
        for(String dead : deadends){
            deadList.add(dead);
        }
        // 初始化
        queue.offer("0000");
        visited.add("0000");
        while(queue.size() > 0){
            int size = queue.size();
            // 每一层
            for(int i = 0; i < size; i++){
                String number = queue.poll();
                // 走到死锁点不再扩散
                if(deadList.contains(number)){
                    continue;
                }
                // 找到值返回
                if(target.equals(number)){
                    return step;
                }
                // 将相邻节点加入队列，如果已经走过就不加入队列
                for(int j = 0; j < 4;j++){
                    // 可以转顺时针逆时针两个方向
                    String up = upRoll(number,j);
                    String down = downRoll(number,j);
                    if(visited.add(up)){
                        queue.offer(up);
                    }
                    if(visited.add(down)){
                        queue.offer(down);
                    }

                }
            }
            step++;
        }
        // 遍历完成没有找到目标
        return -1;

    }
    // 逆时针转一下
    private String upRoll(String ori,int i){
        char[] charArray = ori.toCharArray();
        if(charArray[i] == '9'){
            charArray[i] = '0';
        } else {
            charArray[i] =  (char)(charArray[i] + 1);
        }
        return new String(charArray);
    }
    // 顺时针转一下
    private String downRoll(String ori,int i){
        char[] charArray = ori.toCharArray();
        if(charArray[i] == '0'){
            charArray[i] = '9';
        } else {
            charArray[i] =  (char)(charArray[i] - 1);
        }
        return new String(charArray);
    }
}