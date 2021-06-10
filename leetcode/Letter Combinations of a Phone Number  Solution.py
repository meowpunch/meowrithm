class Solution:
    def digitToCharacters(self, d: str) -> List[str]:
        return {
            "2": ["a", "b", "c"],
            "3": ["d", "e", "f"],
            "4": ["g", "h", "i"],
            "5": ["j", "k", "l"],
            "6": ["m", "n", "o"],
            "7": ["p", "q", "r", "s"],
            "8": ["t", "u", "v"],
            "9": ["w", "x", "y", "z"]
        }.get(d, [])

    def dfs(self, digits: str) -> List[str]:
        chars = self.digitToCharacters(digits[0])

        if len(digits) == 1:
            return chars
        else:
            res = []
            postfix = self.dfs(digits[1:])
            for c in chars:
                for p in postfix:
                    res.append(c + p)

            return res

    def letterCombinations(self, digits: str) -> List[str]:
        return [] if not digits else self.dfs(digits)