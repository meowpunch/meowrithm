# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def printList(head: ListNode):
    curr = head
    container = []
    while curr:
        container.append(curr.val)
        curr = curr.next
    print(container)


class Solution:
    def insertionSortList(self, head: ListNode) -> ListNode:

        resHead = ListNode()

        curr = head
        while curr:
            # printList(resHead)

            # disconnect
            post = curr.next
            curr.next = None

            # insert
            if not resHead.ne xt:
                resHead.next = curr
                curr = post

                continue

            temp = resHead.next
            prev = resHead
            while temp:
                if curr.val < temp.val:
                    prev.next = curr
                    curr.next = temp
                    break

                prev = temp
                temp = temp.next
            else:
                prev.next = curr

            curr = post

        return resHead.next


if __name__ == '__main__':
    node5 = ListNode(5, None)
    node4 = ListNode(4, node5)
    node3 = ListNode(3, node4)
    node2 = ListNode(2, node3)
    node1 = ListNode(1, node2)

    curr = node1

    while curr:
        print(curr.val)
        curr = curr.next

    curr = node1
    post = curr.next
    print(post, curr.next)
    curr.next = None

    print(post.val, curr.next)

    curr = None

    print(node1.val, curr)

    # call by reference
    a = [1, 2, 3]
    b = a

    a.append(4)

    print(a, b)
