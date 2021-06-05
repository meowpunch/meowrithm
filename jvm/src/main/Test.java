package main;

import main.structure.ListNode;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        ReversedLinkedList solution = new ReversedLinkedList();
        ListNode reversed = solution.reverseList(head);

        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
    }
}
