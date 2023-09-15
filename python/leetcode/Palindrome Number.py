class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        elif x == 0:
            return True

        integers = []
        while x > 0:
            integers.append(x % 10)
            x //= 10

        N = len(integers)
        for i in range(N // 2 + 1):
            if integers[i] != integers[N - i - 1]:
                return False

        return True
