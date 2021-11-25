# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# 0 1 2 3 4 5 ... 3(서클 사이즈 10)라면 얼만큼 갔을까?
# t 만큼 지났다면, 토끼는 2t 거북이는 t만큼 이동함
# 거북이가 3일때, 토끼는 6임.
# 20 - 3? 17만큼 지나면 만남. 총 20 (어찌됐던 서클 사이즈 두배를 가야 따라잡음)

# 출발점이 같은데서 반복이 시작된다면 서클사이즈(S)의 두배가 지나면 무조건 만남
# i만큼 앞서있기 때문에 S*2 - i 후에 만남(한번에 한칸씩만 더 앞서나감) 즉 S*2 지나면 만남

class Solution:
    def detectCycle(self, head: ListNode) -> ListNode:

        # hare and tortoise
        # hare twice as fast as tortoise
        hare = head
        tort = head

        while hare and hare.next and hare.next.next:
            hare = hare.next.next
            tort = tort.next

            if hare == tort:
                break
        else:
            return None

        # when tort meets hare,
        # beginning node of cycle is front of tort as far as head of linked list
        res = head
        while True:
            if res == tort:
                return res

            res = res.next
            tort = tort.next

    def detectCycle2(self, head: ListNode) -> ListNode:
        visited = []

        cur = head
        while cur.next:
            print(cur.val)
            visited.append(cur)
            cur = cur.next

            if cur in visited:
                print('ok')
                return cur.val

        return None
