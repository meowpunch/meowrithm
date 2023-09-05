class Solution:

    def kthFactor(self, n: int, k: int) -> int:
        divisors, sqrt_n = [], int(n ** 0.5)
        for i in range(1, sqrt_n + 1):
            if n % i == 0:
                k = k - 1
                divisors.append(i)
                if k == 0:
                    return i

        if sqrt_n * sqrt_n == n:
            k += 1

        if k <= len(divisors):
            return n // divisors[-k]
        else:
            return -1

    def kthFactorWithBruteforce(self, n: int, k: int) -> int:
        for i in range(1, n + 1):
            if n % i == 0:
                k = k - 1
                if k == 0:
                    return i

        return -1
