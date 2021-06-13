# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def linearMemory(self, head: ListNode) -> bool:
        mem = dict()

        curr = head
        while curr:
            currId = id(curr)
            print(mem)
            if mem.get(currId, None):
                return True

            mem[currId] = curr
            curr = curr.next

        return False

    def constantMemory(self, head: ListNode) -> bool:
        """
        Floyd's Cycle Finding Algorithm

        0 1 2 3(cycle) 4 5 .. 10

        3(n) - 8(k 주기)

        a slow pointer takes n steps to enter the cycle, when a fast pointer is in (2n + 1) idx
        that is, the fast is n + 1 steps further than slow.

        0 1 2 3 4 5 6 7 ...
              s(0)    f(n + 1)

        Difference of two pointers' speed is 1, Distance btw two pointers is k - n
        So, After k - n, two pointers will meet.
        """
        if not head or not head.next:
            return False

        slow = head
        fast = head.next

        while slow != fast:
            if not fast.next or not fast.next.next:
                return False

            slow = slow.next
            fast = fast.next.next

        return True

    def hasCycle(self, head: ListNode) -> bool:
        return self.constantMemory(head)  # self.linearMemory(head)