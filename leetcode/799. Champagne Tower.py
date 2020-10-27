# 5개
#       1
#      1 1
#     5 1 5

# 7개
#       1
#      1 1
#     1 1 1
#      5 5

# 8.5개
#       1
#      1 1
#     1 1 1
#   25 1 1 25

# simulation
class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:

        tower = [[0.0] * (i + 1) for i in range(101)]

        # top
        tower[0][0] = poured

        for i in range(query_row + 1):
            for j in range(i + 1):
                # print(i, j)

                if tower[i][j] > 1:
                    overflow = tower[i][j] - 1
                    tower[i][j] = 1.0

                    tower[i + 1][j] += overflow / 2
                    tower[i + 1][j + 1] += overflow / 2
                else:
                    continue

        # print(tower)
        return tower[query_row][query_glass]
