package offer.Linked;

/**
 * 剑指Offer（十四）：链表中倒数第k个结点
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/28 11:01
 */
public class FindKthToTail {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private int findKthToTail(ListNode head,int k){
        ListNode slow = head;
        ListNode fast = head;
        while (k --> 0){
            if (fast == null || fast.next ==null) {
                return 0;
            }
            fast = fast.next;
        }
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);

        System.out.println(new FindKthToTail().findKthToTail(head,2));
    }
}
