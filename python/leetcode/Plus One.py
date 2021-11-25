class Solution:
    def toInt(self, arr: List[int]) -> int:
        r, d = 0, len(arr) - 1
        for v in arr:
            r += v * 10 ** d
            d -= 1
        return r

    def toList(self, num: int) -> List[int]:
        r = list()
        while num > 0:
            r.append(num % 10)
            num = num // 10
        return reversed(r)

    def plusOne(self, digits: List[int]) -> List[int]:
        return self.toList(self.toInt(digits) + 1)

