class Solution:
    def minCostToMoveChips(self, position: List[int]) -> int:

        size = len(position)
        odd = 0
        even = 0

        for val in position:
            if val % 2 == 0:
                even += 1
            else:
                odd += 1

        return min(odd, even)
