class Solution:
    def memoization(self, board: List[List[str]]) -> bool:
        """
        numbering square
        0 1 2
        3 4 5
        6 7 8
        """
        # constant space
        row = [[False] * 10 for _ in range(9)]
        column = [[False] * 10 for _ in range(9)]
        square = [[False] * 10 for _ in range(9)]

        for c in range(9):
            for r in range(9):
                # print(row, column, sqaure)
                if board[r][c] == ".":
                    continue
                else:
                    v = int(board[r][c])

                    if row[r][v] or column[c][v] or square[(r // 3) * 3 + c // 3][v]:
                        return False
                    else:
                        row[r][v], column[c][v], square[(r // 3) * 3 + c // 3][v] = True, True, True

        return True

    def isValidSudoku(self, board: List[List[str]]) -> bool:
        return self.memoization(board)