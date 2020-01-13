package leetcode.top250;

import javafx.scene.input.RotateEvent;

/**
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateRight {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode root = new ListNode(-1);
        root.next = head;
        int nodeNum = 0;
        while (head != null){
            head = head.next;
            nodeNum ++;
        }
        k %= nodeNum;
        head = root.next;
        if (k == 0) return head;
        //反转链表
        head = rev(head,0);
        return rev(head,k);
    }

    private ListNode rev(ListNode head,int k){
        ListNode pre = null;
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
            count++;
            if (k!=0 && k==count){
                ListNode root = new ListNode(-1);
                root.next = pre;
                while (pre.next!=null){
                    pre = pre.next;
                }
                pre.next = rev(cur,0);
                return root.next;
            }
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode root = new RotateRight().rotateRight(head,2);
        System.out.println(1);
    }
}
