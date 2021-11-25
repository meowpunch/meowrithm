class Solution:
    """
    last digit of MAX, MIN -> 7, -8
    """
    MAX = 2 ** 31 - 1
    MIN = -2 ** 31

    def reverseInt(self, x: int) -> int:
        r = 0
        while x != 0:
            # rest of python is different from Java or C
            p = (x % 10 if x > 0 else - (abs(x) % 10))

            if r < self.MIN / 10 or (r < self.MIN / 10 and p < -8):
                return 0
            if self.MAX / 10 < r or (self.MAX / 10 < r and p > 7):
                return 0

            r = r * 10 + p
            x = int(x / 10)

        return r

    def reverseString(self, x: int) -> int:
        """
        Ignore the environment does not allow you to store 64-bit integers (signed or unsigned).
        """
        s = str(x)
        n = s.replace("-", "")
        r = "".join(reversed(list(n)))
        f = int("-" + r) if "-" in s else int(r)

        if -2 ** 31 <= f <= 2 ** 31 - 1:
            return f
        else:
            return 0

    def reverse(self, x: int) -> int:
        return self.reverseInt(x)
