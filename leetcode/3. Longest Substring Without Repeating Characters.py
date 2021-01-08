class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # linear searching

        # Length of Longest Substring
        LLS = 0
        # temp Substring
        tempS = ""
        # length of temp Substring
        tempLS = 0

        for i, c in enumerate(s):
            try:
                idx = tempS.index(c)

                if LLS < tempLS:
                    LLS = tempLS

                tempS = tempS[idx + 1:] + c
                tempLS = tempLS - (idx + 1) + 1


            except:
                tempS += c
                tempLS += 1

        if LLS < tempLS:
            LLS = tempLS

        return LLS