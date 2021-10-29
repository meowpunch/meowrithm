package leetcode;

import java.util.HashMap;
import java.util.List;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache c = new LRUCache(2);
        System.out.println(c.get(1));
        c.printList();
        c.put(1, 1);
        c.printList();
        c.put(2, 2);
        c.printList();
        System.out.println(c.get(1));
        c.printList();
        c.put(3, 3);
        c.printList();
        System.out.println(c.get(2));
        c.printList();

        c = new LRUCache(1);
        System.out.println(c.get(1));
        c.printList();
        c.put(2, 1);
        c.printList();
        System.out.println(c.get(2));
        c.printList();
        c.put(3, 2);
        c.printList();
        System.out.println(c.get(2));
        c.printList();
    }

    /*
        doubly linked list
        lru - ??? - mru
     */
    class Node {
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int key;
        public int val;
        public Node prev;
        public Node next;

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    private final int c;
    private final HashMap<Integer, Node> m;
    // least recently used node
    private Node lru;
    // most recently used node
    private Node mru;

    public LRUCache(int capacity) {
        this.c = capacity;
        this.m = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (!m.containsKey(key)) return -1;
        else {
            Node n = m.get(key);

            // move node to mru
            setMRUNode(n);

            return n.val;
        }
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node n = m.get(key);

            // move node to mru
            setMRUNode(n);
        } else {
            Node n = new Node(key, value);

            // evict
            if (c <= m.size()) {
                m.remove(lru.key);
                evictLRUNode();
            }

            addMRUNode(n);
            m.put(key, n);
        }
    }

    private void setMRUNode(Node n) {
        // delete n
        if (n.prev != null) n.prev.next = n.next;
        else lru = n.next;

        if (n.next != null) n.next.prev = n.prev;
        else mru = n.prev;

        addMRUNode(n);
    }

    private void addMRUNode(Node n) {
        if (mru == null) {
            mru = n;
            lru = n;
        } else {
            n.next = null;
            mru.next = n;
            n.prev = mru;
            mru = n;
        }
    }

    private void evictLRUNode() {
        lru = lru.next;
        if(lru != null) lru.prev = null;
        else mru = null;
    }

    public void printList() {
        System.out.printf("lru: %s, mru: %s\n", lru, mru);

        Node n = lru;
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(String.format("%s ", n));

            n = n.next;
        }

        System.out.println(sb);
    }
}
