class Solution:
    @staticmethod
    def memoization(s: str) -> int:
        """
        time, space: O(n)
        """
        mem = dict()

        for c in s:
            mem[c] = mem.get(c, 0) + 1

        for i, c in enumerate(s):
            if mem.get(c) == 1:
                return i

        return -1

    def firstUniqChar(self, s: str) -> int:
        return self.memoization(s)
