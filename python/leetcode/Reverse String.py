class Solution:
    def reverseString(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.

        time: O(n)
        space: O(1)
        """
        n = len(s)
        for l in range(n // 2):
            r = (n - 1) - l
            # swap
            s[l], s[r] = s[r], s[l]

