class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.

        make space complexity be constant
        """

        zeroCol = False
        zeroRow = False

        rowL = len(matrix)
        colL = len(matrix[0])

        # marking    
        for r in range(0, rowL):
            for c in range(0, colL):
                if r is 0:
                    if matrix[0][c] is 0:
                        zeroRow = True

                if c is 0:
                    if matrix[r][0] is 0:
                        zeroCol = True

                if matrix[r][c] is 0:
                    matrix[r][0] = 0
                    matrix[0][c] = 0

        # set zero except for first row and column
        for r in range(1, rowL):
            for c in range(1, colL):
                if not matrix[r][0] or not matrix[0][c]:
                    matrix[r][c] = 0

        # set zero for first row
        if zeroRow:
            for c in range(colL):
                matrix[0][c] = 0

        # set zero for first col
        if zeroCol:
            for r in range(rowL):
                matrix[r][0] = 0
