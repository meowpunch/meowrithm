# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        # You should try to do it in place.
        # The program should run in O(1) space complexity and O(nodes) time complexity.
        # 1 2 3 4 5
        # oddHead -> 1 -> 3 -> 5
        # evenHead -> 2 -> 4
        curr = head
        index = 1

        oddHead = oddCurr = ListNode()
        evenHead = evenCurr = ListNode()

        while curr:
            if index % 2 is 0:
                # even
                evenCurr.next = curr
                evenCurr = evenCurr.next
            else:
                # odd
                oddCurr.next = curr
                oddCurr = oddCurr.next

            curr = curr.next
            index += 1

        oddCurr.next = evenHead.next
        evenCurr.next = None

        return oddHead.next