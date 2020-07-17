package tencent;

import java.util.List;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int left,int right){
        if (left == right)
            return lists[left];
        int mid = (left+right) >> 1;
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid+1,right);
        return mergeToLists(l1,l2);
    }

    public ListNode mergeToLists(ListNode l1,ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val){
            l1.next = mergeToLists(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeToLists(l1,l2.next);
            return l2;
        }
    }
}