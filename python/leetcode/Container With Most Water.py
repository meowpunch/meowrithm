class Solution:
    #
    #   1 6 7 2 5 4 8 3 7
    #   i               j
    #
    #   if height[i] < height[j]
    #       j++ cannot increase area
    def maxArea(self, height: List[int]) -> int:
        i, j = 0, len(height) - 1
        max_area = 0

        while i < j:
            cur_area = (j - i) * min(height[i], height[j])
            max_area = max(max_area, cur_area)

            if height[i] < height[j]:
                i += 1
            else:
                j -= 1

        return max_area
