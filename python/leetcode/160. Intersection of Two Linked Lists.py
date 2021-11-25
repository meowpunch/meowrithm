# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


def getListLength(l: ListNode):
    length = 0

    while l:
        l = l.next
        length += 1

    return length


class Solution:

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        # Your code should preferably run in O(n) time and use only O(1) memory.

        lenA, lenB = getListLength(headA), getListLength(headB)
        # print(lenA, lenB)

        diff = lenA - lenB
        if diff >= 0:
            # lenA >= lenB
            while diff > 0:
                headA = headA.next
                diff -= 1
        else:
            # lenB > lenA
            diff = abs(diff)
            while diff > 0:
                headB = headB.next
                diff -= 1

        while headA and headB:
            if headA is headB:
                return headA

            headA = headA.next
            headB = headB.next

        return None


if __name__ == '__main__':
    head1 = ListNode(1)
    head2 = ListNode(2)

    head = ListNode(3)
    curr = head
    curr.next = ListNode(4)

    head1.next = head
    head2.next = head

    print(head1.next == head2.next)
    print(head1.next is head2.next)