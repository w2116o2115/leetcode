package array;

import java.util.Arrays;

/**
 * 621. 任务调度器
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。任务可以以任意顺序执行，
 * 并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
 *
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的最短时间。 
 *
 * 示例 ：
 *
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 *      在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。
 *
 * 思路：对任务进行排序，首先执行不同的任务，不同的任务执行的之间大于冷却时间就不用待命，如果小于冷却时间就需要待命
 *
 * ASCII和字符互相转换
 *   0~9：48~57
 *   A~Z：65~90
 *   a~z：97~122
 */
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c:tasks)
            map[c-'A']++;
        Arrays.sort(map);
        int res = 0;
        while (map[25] >0){
            int i=0;
            while (i<=n){
                if (map[25] == 0)
                    break;
                if (i<26 && map[25-i] > 0){
                    map[25-i]--;
                }
                res++;
                i++;
            }
            Arrays.sort(map);
        }
        return res;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','B'};
        System.out.println(new LeastInterval().leastInterval(tasks,2));
    }
}
