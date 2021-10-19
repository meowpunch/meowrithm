package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
    // Definition for a Node.
    private class Node {
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

    private class QNode {
        public final Node node;
        // depth >= 0 (0 represents root)
        public final int depth;

        QNode(Node node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public Node connect(Node root) {
        // null check, in case that # nodes is 0
        if (root == null) return null;

        Queue<QNode> que = new LinkedList<>();
        que.offer(new QNode(root, 0));

        QNode prev = null;
        while(!que.isEmpty()) {
            final QNode curr = que.poll();

            // same level
            if (prev != null && curr.depth == prev.depth) {
                prev.node.next = curr.node;
            }

            if (curr.node.left != null) que.offer(new QNode(curr.node.left, curr.depth + 1));
            if (curr.node.right != null) que.offer(new QNode(curr.node.right, curr.depth + 1));

            prev = curr;
        }

        return root;
    }
}
