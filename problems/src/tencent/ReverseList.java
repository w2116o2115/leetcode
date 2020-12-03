package tencent;

/**
 * 206. 反转链表
 */
public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reve(ListNode head) {
        if (head.next == null) return head;
        ListNode tail = reve(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode node = new ReverseList().reve(head);
        System.out.println(1);
    }
}
