# The isBadVersion API is already defined for you.
# @param version, an integer
# @return an integer
# def isBadVersion(version):

class Solution:
    def recursiveBS(self, l, r):
        if l >= r:
            return l

        m = (l + r) // 2

        if isBadVersion(m):
            return self.recursiveBS(l, m)
        else:
            return self.recursiveBS(m + 1, r)

    def iterativeBS(self, n):
        l, r = 1, n

        while l < r:
            # print(l, r)
            m = (l + r) // 2

            if isBadVersion(m):
                r = m
            else:
                l = m + 1

        return l

    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        return self.recursiveBS(1, n)  # self.iterativeBS(n)
