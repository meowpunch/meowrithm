# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def getDecimalValue(self, head: ListNode) -> int:
        # 101
        # 1 * 10^0 + 0 * 10^1 + 1 * 10^2
        # using stack

        stack = []
        curr = head

        while curr:
            stack.append(curr.val)
            curr = curr.next

        res = 0
        i = 0
        while stack:
            digit = stack.pop()
            res += digit * (2 ** i)
            i += 1

        return res