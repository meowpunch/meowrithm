import re
from typing import List


class Solution:
    def longestValidSubstring(self, word: str, forbidden: List[str]) -> int:
        indices = []
        forbidden = set(forbidden)
        N = len(word)
        for forbiddenWord in forbidden:
            s = 0
            while s + len(forbiddenWord) <= N:
                e = s + len(forbiddenWord)
                if word[s:e] == forbiddenWord:
                    indices.append((s, e))
                s += 1

        sorted_indices = sorted(indices, key=lambda kv: kv[0])

        score = 0
        n = len(sorted_indices)

        if n == 0:
            return N

        pre_idx = 0
        # Greedy
        for start, end in sorted_indices:
            score = max(score, end - 1 - pre_idx)
            pre_idx = start + 1

        score = max(score, N - pre_idx)

        return score

if __name__ == '__main__':
