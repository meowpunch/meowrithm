class Solution:
    #
    #   "I"
    #   "II"
    #   "III"
    #   "IV"
    #   "V"
    #   "VI"
    #   "VII"
    #   "VIII"
    #   "IX"
    #   X
    #   XI  11
    #   XII
    #   XIII
    #   XIV
    #   XV
    #   XVI
    #   XVII
    #   XVIII
    #   XIX
    #   XX
    #
    #   58
    #   55 + 3
    #   50 + 5 + 3
    #   LVIII
    #
    #
    #   1994
    #   1990 + 4
    #   1990 + 0 + 4
    #   1950 + 40 + 4
    #   1900 + 50 + 40 + 4
    #   1500 + 400 + 50 + 40 + 4
    #   1000 + 500 + 400 + 50 + 40 + 4
    #   MDCD
    #
    #
    #   89
    #   85 + 4
    #
    #
    def intToRoman(self, num: int) -> str:
        first = ["", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"]
        second = ["", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"]
        third = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"]
        forth = ["", "M", "MM", "MMM"]

        return forth[num // 1000 % 10] + third[(num // 100) % 10] + second[
            (num // 10) % 10] + first[num % 10]
