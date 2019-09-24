package linked_list;

/**
 * 147. 对链表进行插入排序
 *
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 多指针  用纸画
 *
 */
public class InsertionSortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        //定义三个指针 pre cur last
        ListNode h = new ListNode(-1);
        h.next = head;
        ListNode pre = h;
        ListNode cur = head;
        ListNode last;
        while (cur!=null){
            last = cur.next;//记录下一个要出入排序的值
            if (last!=null && last.val<cur.val){
                while (pre.next != null && pre.val < last.val){
                    pre = pre.next;
                }
                ListNode tmp = pre.next;
                pre.next = last;
                cur.next = last.next;
                last.next = tmp;
                pre = h;
            }else {
                cur = last;
            }
        }
        return h.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        ListNode node = new InsertionSortList().insertionSortList(head);

        System.out.println(1);
    }
}
