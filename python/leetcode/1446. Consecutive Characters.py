class Solution:
    def maxPower(self, s: str) -> int:
        maxVal = 1
        prev = None
        count = 0

        for curr in s:
            if prev and prev == curr:
                count += 1
                prev = curr
            else:
                prev = curr
                count = 1

            maxVal = max(count, maxVal)

        return maxVal

