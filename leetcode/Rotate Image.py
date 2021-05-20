class Solution:
    def rotating(self, matrix: List[List[int]]) -> None:
        """
        approach diagonally
        0,0 -> 1,1 -> ... -> i, j -> ... -> n//2, n//2

        """
        n = len(matrix[0])

        for i in range(n // 2):
            for j in range(i, n - i - 1):
                """
                n = 7, i = 1, j = 2

                i, j -> j, n-1-i -> n-1-i, n-1-j -> n-1-j, i
                1, 2 -> 2, 5     -> 5, 4         -> 4, 1
                """
                tmpV = matrix[i][j]
                matrix[i][j] = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = tmpV

    def rotate(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.

        """
        self.rotating(matrix)
