class Solution:
    def isPalindrome(self, s: str) -> bool:
        """
        time: O(n)
        space: O(1)
        """
        # lower
        sl = s.lower()
        l, r = 0, len(sl) - 1

        # two pinter
        while l < r:
            while l < r and not sl[l].isalnum():
                l += 1

            while l < r and not sl[r].isalnum():
                r -= 1

            if l < r and sl[l] != sl[r]:
                return False
            else:
                l += 1
                r -= 1

        return True
