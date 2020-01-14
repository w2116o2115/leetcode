package offer.Linked;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/28 11:23
 */
public class RevLinked {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode revLinked(ListNode head){
        ListNode preNode = null;
        ListNode curNode = head;
        ListNode nextNode = null;

        while (curNode.next != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }

        return preNode;
    }

    ListNode reverse(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode root = new RevLinked().reverse(head);
        System.out.println(1);
    }
}
