class Solution:
    def romanToInt(self, s: str) -> int:
        map = {
            "I": 1,
            "V": 5,
            "X": 10,
            "L": 50,
            "C": 100,
            "D": 500,
            "M": 1000}

        unique = {
            "IV": 4,
            "IX": 9,
            "XL": 40,
            "XC": 90,
            "CD": 400,
            "CM": 900
        }

        N = len(s)
        r = i = 0
        while i < N:
            if i + 1 < N:
                cc = s[i: i + 2]
                if s[i: i + 2] in unique:
                    r += unique[cc]
                    i += 2
                    continue

            r += map[s[i]]
            i += 1

        return r
