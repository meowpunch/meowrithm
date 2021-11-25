# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        newHead = ListNode(next=head)
        prev = newHead
        curr = newHead.next
        flag = False

        while curr and curr.next:
            if flag and (curr.val != curr.next.val):
                # drop duplicates
                prev.next = curr.next
                flag = False
            elif curr.val == curr.next.val:
                flag = True
            else:
                prev = curr

            curr = curr.next

        if flag:
            prev.next = None

        return newHead.next
