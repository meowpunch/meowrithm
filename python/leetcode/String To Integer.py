class Solution:
    def myAtoi(self, s: str) -> int:
        """
        time: O(n)
        space: O(n)
        """
        # rm left right whitespace
        s = s.strip()
        r = ""

        try:
            # check sign
            if s[0] in "-+":
                r += s[0]
                s = s[1:]

            for c in s:
                if c.isdigit():
                    r += c
                    if int(r) >= 2 ** 31:
                        return 2 ** 31 - 1
                    if int(r) < -2 ** 31:
                        return -2 ** 31
                else:
                    break

            return int(r)
        except:
            return 0
