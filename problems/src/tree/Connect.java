package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 提示：
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 */
public class Connect {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return null;
        bfsHepler(root);
        return root;
    }

    private void bfsHepler(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count --> 0) {
                Node node = queue.poll();
                node.next = count==0?null:queue.peek();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        Node node4 = new Node(4,null,null,null);
        Node node5 = new Node(5,null,null,null);
        Node node6 = new Node(6,null,null,null);
        Node node7 = new Node(7,null,null,null);
        Node node2 = new Node(2,node4,node5,null);
        Node node3 = new Node(3,node6,node7,null);
        Node node1 = new Node(1,node2,node3,null);
        new Connect().connect(node1);
        System.out.println(1);
    }
}