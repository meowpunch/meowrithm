package others;


import data.ListNode;

public class ReversedLinkedList {
    private ListNode recursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode iteration(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head) {
        return iteration(head); // return recursion(head);
    }
}

