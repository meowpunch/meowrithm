# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# not necessary
def pow(x: int, y: int) -> int:
    # x^y
    if y <= 0:
        return 1

    return x * pow(x, y - 1)


def toValue(l: ListNode) -> int:
    # except for leading 0
    # l = l.next
    value, i = 0, 0
    while l:
        value += l.val * pow(10, i)
        l = l.next
        i += 1

    return value


def toList(v: int) -> ListNode:
    head = tail = ListNode(0)

    while v >= 10:
        tail.next = ListNode(v % 10)
        tail = tail.next
        v //= 10

    tail.next = ListNode(v % 10)
    return head.next


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        return toList(toValue(l1) + toValue(l2))




