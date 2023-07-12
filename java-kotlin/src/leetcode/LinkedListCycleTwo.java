package leetcode;

import java.util.Optional;

public class LinkedListCycleTwo {

  public ListNode detectCycle(ListNode head) {
    var fastPointer = head;
    var slowPointer = head;

    while (fastPointer != null || slowPointer != null) {
      fastPointer = moveTwoSteps(fastPointer);
      slowPointer = moveOneStep(slowPointer);

      if (slowPointer == fastPointer) {
        slowPointer = head;
        while (slowPointer != fastPointer) {
          slowPointer = moveOneStep(slowPointer);
          fastPointer = moveOneStep(fastPointer);
        }
        return slowPointer;
      }
    }

    return null;
  }

  private ListNode moveTwoSteps(ListNode current) {
    return Optional.ofNullable(moveOneStep(current)).map(this::moveOneStep).orElse(null);
  }

  private ListNode moveOneStep(ListNode current) {
    return Optional.ofNullable(current).map(n -> n.next).orElse(null);
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
    next = null;
  }
}