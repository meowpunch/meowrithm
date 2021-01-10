class Solution:
    def longestPalindrome(self, s: str) -> str:
        # Two Pointers
        # TC - O(n^2)
        # SC - O(1)
        L = len(s)
        left, right = 0, 0
        for i in range(L):

            def twoPointers(l: int, r: int):
                # expand around center
                while 0 <= l and r < L and s[l] is s[r]:
                    l -= 1
                    r += 1

                return l + 1, r - 1

            l1, r1 = twoPointers(i, i)
            diff1 = r1 - l1

            l2, r2 = twoPointers(i, i + 1)
            diff2 = r2 - l2

            if diff1 >= diff2:
                if diff1 > (right - left):
                    left, right = l1, r1
            else:
                if diff2 > (right - left):
                    left, right = l2, r2

            print(left, right)

        return s[left: right + 1]

    def longestPalindrome2(self, s: str) -> str:
        # DP
        # TC - O(n^2)
        # SC - O(n^2)
        # table[i][j] represents the truth that a substring(i to j) is palindromic x

        L = len(s)
        table = [[False for _ in range(L)] for _ in range(L)]
        maxDiff = 0
        maxI = 0
        maxJ = 0

        for j in range(L):
            for i in range(0, j + 1):
                # if not table.get(i):
                #     table[i] = dict()

                diff = j - i
                # print(i, j)

                if s[i] is s[j] and (diff < 2 or table[i + 1][j - 1]):
                    table[i][j] = True

                    if maxDiff < diff:
                        maxDiff = diff
                        maxI = i
                        maxJ = j

        # print(maxDiff, maxI, maxJ)
        return s[maxI:maxJ + 1]


if __name__ == '__main__':
    print(Solution().longestPalindrome2("babad"))
