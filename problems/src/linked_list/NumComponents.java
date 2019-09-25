package linked_list;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 *
 * 给定一个链表（链表结点包含一个整型值）的头结点 head。
 *
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 *
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 *
 * 示例 1：
 *
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 *
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * 注意:
 *
 * 如果 N 是给定链表 head 的长度，1 <= N <= 10000。
 * 链表中每个结点的值所在范围为 [0, N - 1]。
 * 1 <= G.length <= 10000
 * G 是链表中所有结点的值的一个子集.
 */
public class NumComponents {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int numComponents(ListNode head, int[] G) {
        if (head == null || G == null || G.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int a:G){
            set.add(a);
        }

        int res = 0;
        int count = 0;

        while (head != null){
            if (set.contains(head.val)){
                set.remove(head.val);
                count++;
            }else {
                if (count > 0) {
                    res++;
                    count = 0;
                }
            }
            head = head.next;
        }
        return count == 0?res:res+1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        int[] A = new int[]{0, 3, 1, 4};

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(new NumComponents().numComponents(head,A));
    }
}
