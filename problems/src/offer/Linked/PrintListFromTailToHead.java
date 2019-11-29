package offer.Linked;

import java.util.Stack;

/**
 * 剑指Offer（三）：从尾到头打印链表
 * @author Carlose wei
 * @version 1.0
 * @date 2019/11/28 10:39
 */
public class PrintListFromTailToHead {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private void trade(ListNode node,Stack<Integer> list){
        if (node.next == null) {
            list.push(node.val);
            return;
        }
        list.push(node.val);
        trade(node.next,list);
    }

    public Stack<Integer> printListFromTailToHead(ListNode head){
        Stack<Integer> list = new Stack<>();
        trade(head,list);
        return list;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        Stack<Integer> list = new PrintListFromTailToHead().printListFromTailToHead(head);
        while (!list.isEmpty()){
            System.out.println(list.pop());
        }
    }
}
