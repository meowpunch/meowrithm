class Solution:
    def memoization(self, s: str, t: str) -> bool:
        """
        time, space: O(n)
        """
        mem = dict()
        for c in s:
            mem[c] = mem.get(c, 0) + 1

        for c in t:
            m = mem.get(c, 0)
            if m == 0:
                return False
            mem[c] = m - 1

        return True if sum(mem.values()) == 0 else False

    def sorting(self, s: str, t: str) -> bool:
        """
        time: O(nlogn)
        space: O(n)
        """
        return sorted(list(s)) == sorted(list(t))

    def isAnagram(self, s: str, t: str) -> bool:
        return self.memoization(s, t)
