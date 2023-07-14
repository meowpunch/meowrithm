package leetcode.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode h = new MergeKSortedLists().mergeKLists(
                new ListNode[]{
                        new ListNode(1, new ListNode(4, new ListNode(5, null))),
                        new ListNode(1, new ListNode(3, new ListNode(4, null))),
                        new ListNode(2, new ListNode(6, null))
                }
        );

        while (h != null){
            System.out.println(h.val);
            h = h.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*
        - each head element of k lists
        - pick only min of k head elements
            with priority queue, O(k) -> O(log k)
        - add it to merged list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return optimized(lists);
    }

    public ListNode optimized(ListNode[] lists) {
        final PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(l -> l.val));
        final ListNode head = new ListNode(0); // dummy node

        // O(N)
        for (ListNode l : lists) {
            if (l != null) pq.offer(l);
        }

        ListNode curr = head;
        while (!pq.isEmpty()) {
            final ListNode n = pq.poll();
            curr.next = n;
            curr = curr.next;

            if (n.next != null) pq.offer(n.next);
        }

        return head.next;
    }

    /*
        O(N * k)
     */
    private ListNode compareOneByOne(ListNode[] lists) {
        if (lists.length == 0) return null;
        // dummy value
        final ListNode head = new ListNode(0);

        ListNode curr = head;
        while (!isAllListEmpty(lists)) {
            int mi = 0;
            ListNode mn = lists[0];
            for (int i = 1; i < lists.length; i++) {
                final ListNode n = lists[i];
                if (n != null && ((mn == null) || mn.val > n.val)) {
                    mn = n;
                    mi = i;
                }
            }

            curr.next = new ListNode(mn.val);
            curr = curr.next;

            lists[mi] = mn.next;
        }

        return head.next;
    }

    private boolean isAllListEmpty(ListNode[] lists) {
        for (ListNode l : lists) if (l != null) return false;
        return true;
    }

}
