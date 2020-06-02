package breadth_first_search;

import java.util.*;

/**
 * 特定深度节点链表
 *
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 * 示例：
 *
 * 输入：[1,2,3,4,5,null,7,8]
 *         1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *    /
 *   8
 *
 * 输出：[[1],[2,3],[4,5,7],[8]]
 */
public class ListOfDepth {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> listNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        queue.offer(null);
        ListNode head = new ListNode(-1);
        ListNode current = null;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node == null){
                listNodes.add(head.next);
                current = null;
                if (!queue.isEmpty()) queue.offer(null);
            }else {
                if (node.left!=null) queue.offer(node.left);
                if (node.right !=null) queue.offer(node.right);
                if (current == null) {
                    current = new ListNode(node.val);
                    head.next = current;
                }else {
                    current.next = new ListNode(node.val);
                    current = current.next;
                }
            }
        }
        return listNodes.toArray(new ListNode[0]);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(8);
        root.right.right = new TreeNode(7);

        ListNode[] res = new ListOfDepth().listOfDepth(root);
        System.out.println(1);
    }
}