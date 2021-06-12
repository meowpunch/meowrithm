from typing import List


class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0

        else:
            n, m = len(haystack), len(needle)
            lps = self.lps(needle)

            i, j = 0, 0
            while i < n:
                while j > 0 and haystack[i] != needle[j]:
                    j = lps[j - 1]

                if haystack[i] == needle[j]:
                    if j == m - 1:
                        return i - (m - 1)
                    j += 1

                i += 1

            return -1

    def lps(self, s: str) -> List[int]:
        """
        lps indicates longest proper prefix which is also suffix.
        ABABC
        00120
        """
        n = len(s)
        lps = [0] * n

        i, j = 1, 0
        while i < n:
            while j > 0 and s[i] != s[j]:
                j = lps[j - 1]

            if s[i] == s[j]:
                j += 1

            lps[i] = j
            i += 1

        return lps

if __name__ == '__main__':
    """
       mississippi
        issip

       issip
       00010
       ------------------
       aabaaabaaac
       aabaaac
           aabaaac

       aabaaac
       0101220
       ------------------
       ABABABC
       ABABC
         ABABC

       ABABC
       00120
       """
    assert Solution().lps("ababc") == [0, 0, 1, 2, 0]
    assert Solution().lps("aaababaaab") == [0, 1, 2, 0, 1, 0, 1, 2, 3, 4]
    assert Solution().lps("issip") == [0, 0, 0, 1, 0]

    print(Solution().strStr("mississippi", "issip"))
    print(Solution().strStr("mississippi", "issipi"))
    print(Solution().strStr("hello", "ll"))
    assert Solution().strStr("mississippi", "issip") == 4
    assert Solution().strStr("hello", "ll") == 2
