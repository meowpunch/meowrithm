# # N: 스테이지 개수 (1 <= N <= 500)
# # stages: 유저가 머물고 있는 스테이지 (1 <= stages <= 200,000)
#
# # 실패율: 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
# # i 스테이지에 도달한 플레이어 수: stages 원소 값이 i 이상인 개수
# # 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수(unclear): stages 원소의 값이 i인 개수
#
# # [2, 1, 2, 6, 2, 4, 3, 3] -> [6, 4, 3, 3, 2, 2, 2, 1] 오름차순 정렬  [1, 2, 2, 2, 3, 3, 4, 6]
#
#
# class Stage:
#     def __init__(self, index):
#         self.index = index
#         self.fail = 0
#         self.total = 0
#         self.score = 0
#
#     def __lt__(self, other):
#         return self.score > other.score
#
#     def scoring(self):
#         if self.total is 0:
#             self.score = 0
#         else:
#             self.score = self.fail / self.total
#
#
# def solution(N, stages):
#     answer = []
#     user_num = len(stages)
#
#     # 내림차순 정렬 후
#     stages.sort(reverse=True)
#
#     buckets = [Stage(index=i + 1) for i in range(N)]
#     for s in stages:
#         for b in buckets:
#             if s > b.index:
#                 b.total += 1
#             elif s is b.index:
#                 b.fail += 1
#                 b.total += 1
#             elif s < b.index:
#                 break
#
#     for b in buckets:
#         b.scoring()
#
#     buckets.sort()
#
#     # for b in buckets:
#     #     print("{}, {}".format(b.index, b.score))
#
#     return list(map(lambda b: b.index, buckets))


# 3 실패, 5 9 22 시간초과
# def solution(N, stages: list):
#     scores = [0] * N
#
#     for i in range(N):
#         cur_stage = i + 1
#
#         total = len(list(filter(lambda x: x >= cur_stage, stages)))
#
#
#         fail = len(list(filter(lambda x: x is cur_stage, stages)))
#
#         if total == 0:
#             scores[i] = (i + 1, 0)
#         else:
#             scores[i] = (i + 1, fail / total)
#
#     scores.sort(key=lambda x: x[1], reverse=True)
#     return list(map(lambda x: x[0], scores))

def solution(N, stages: list):
    scores = []

    for i in range(0, N):
        total = 0
        fail = 0
        cur_stage = i + 1

        for s in stages:
            if s > cur_stage:
                total += 1
            # is 아니고 무조건 == 써야하는데 (is는 같은 object ==는 같은 value)
            # 왜 몇개는 통과하고 몇개는 통과못하는거지? ...
            elif s == cur_stage:
                total += 1
                fail += 1

        if total == 0:
            scores.append((cur_stage, 0))
        else:
            scores.append((cur_stage, fail / total))

    scores.sort(key=lambda x: x[1], reverse=True)

    for s in scores:
        print(s[1])
    return list(map(lambda x: x[0], scores))


if __name__ == '__main__':
    sol = solution(N=5, stages=[2, 1, 2, 6, 2, 4, 3, 3])
    print(sol)
    sol2 = solution(2, [2, 2, 2])
    print(sol2)
