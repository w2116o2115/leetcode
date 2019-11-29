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
}
