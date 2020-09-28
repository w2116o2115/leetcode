package linked_list;

/**
 * 86. 分隔链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Partition {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode left_x = null;
        ListNode mid = null;
        ListNode right_x = null;
        while (head.next != null){
            if (head.next.val > x){
                left_x = head;
                ListNode temp = head.next;
                head.next = null;
                head = temp;
                continue;
            }
            if (head.val == x){
                right_x = head;
                break;
            }
            head = head.next;
        }
        ListNode right_head = right_x;
        if (right_x != null && left_x != null) {
            while (right_x != null) {
                if (right_x.next.val < x){
                    left_x.next = right_x.next;
                    right_x.next = left_x.next!=null?left_x.next.next:null;
                    left_x = left_x.next;
                }
                right_x = right_x.next;
            }
        }
        left_x.next = right_head;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(2);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode root = new Partition().partition(head,3);
        System.out.println(1);
    }
}
