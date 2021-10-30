package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class LRUCache {

    /*


     */
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
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
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

            setNodeToMRU(n);

            return n.val;
        }
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            Node n = m.get(key);

            // update value
            n.val = value;

            setNodeToMRU(n);
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

    /*
        considering n is lru or mru.
     */
    private void setNodeToMRU(Node n) {
        // delete n
        if (isLRU(n)) lru = n.next;
        else n.prev.next = n.next;

        if (isMRU(n)) mru = n.prev;
        else n.next.prev = n.prev;

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
        if (lru == mru) {
            lru = null;
            mru = null;
        } else {
            lru = lru.next;
            lru.prev = null;
        }
    }

    private boolean isLRU(Node n) {
        return n == lru;
    }

    private boolean isMRU(Node n) {
        return n == mru;
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

class LRUCacheWithLinkedHashMap {
    private final int c;
    private final LinkedHashMap<Integer, Integer> m;

    public LRUCacheWithLinkedHashMap(int capacity) {
        this.c = capacity;
        this.m = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (!m.containsKey(key)) return -1;
        else {
            int value = m.get(key);

            m.remove(key);
            m.put(key, value);

            return value;
        }
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) m.remove(key);
        else if (c <= m.size()) m.remove(m.keySet().iterator().next());

        m.put(key, value);
    }
}
