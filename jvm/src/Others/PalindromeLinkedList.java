import Others.structure.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {

        ListNode reversed = getHalfReversed(head);
        while (reversed != null && head != null) {
            if (reversed.val == head.val) {
                reversed = reversed.next;
                head = head.next;
            } else return false;
        }
        return true;
    }

    public ListNode getHalfReversed(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null  && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // odd
        if (fast != null) slow = slow.next;

        return reverse(slow);
    }

    public ListNode reverse(ListNode head) {
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
}
