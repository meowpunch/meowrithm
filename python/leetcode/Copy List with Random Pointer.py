class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None

        curr = head
        m = {}
        while curr:
            m[curr] = Solution.copy(curr)
            curr = curr.next

        for node in m.values():
            if node.next:
                node.next = m[node.next]

            if node.random:
                node.random = m[node.random]

        return list(m.values())[0]

    @staticmethod
    def copy(node: 'Node') -> 'Node':
        return Node(node.val, node.next, node.random)
