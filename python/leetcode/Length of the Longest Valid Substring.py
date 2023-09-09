import re
from typing import List


class Solution:
    #
    #   forbidden[i].length <= 10
    #
    #   word = "leetcode", forbidden = ["de","le","e"]
    #
    #   "acbc", ["acbc", "acb", "cbc"]
    #
    #   "aaaabaaacc", ["bcca","aaa","aabaa","baaac"]
    #
    def longestValidSubstring(self, word: str, forbidden: List[str]) -> int:
        N = len(word)
        forbidden = set(forbidden)
        score = 0
        last = 0
        for end in range(1, N + 1):
            for i in range(10):
                start = end - (i + 1)
                if start >= 0:
                    if word[start:end] in forbidden:
                        score = max(score, end - 1 - last)
                        last = max(last, start + 1)
                        break
                else:
                    break

        score = max(score, N - last)

        return score

    def longestValidSubstringOptimized(self, word: str,
        forbidden: List[str]) -> int:
        N = len(word)
        forbidden = set(forbidden)
        score = 0
        last = 0
        for end in range(1, N + 1):
            # Optimized
            for length in range(min(end - last, 10)):
                start = end - (length + 1)
                if start >= 0:
                    if word[start:end] in forbidden:
                        score = max(score, end - 1 - last)
                        last = max(last, start + 1)
                        break
                else:
                    break

        score = max(score, N - last)

        return score

    #
    #
    #
    def longestValidSubstringTLE(self, word: str, forbidden: List[str]) -> int:
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

        sorted_indices = sorted(indices, key=lambda kv: kv[1])

        score = 0
        n = len(sorted_indices)

        if n == 0:
            return N

        pre_idx = 0
        # Greedy
        for start, end in sorted_indices:
            score = max(score, end - 1 - pre_idx)
            pre_idx = max(pre_idx, start + 1)

        score = max(score, N - pre_idx)

        return score


if __name__ == '__main__':
    print(Solution().longestValidSubstring("aaaabaaacc",
                                           ["bcca", "aaa", "aabaa",
                                            "baaac"]) == 4)
    print(Solution().longestValidSubstringTLE("aaaabaaacc",
                                              ["bcca", "aaa", "aabaa",
                                               "baaac"]) == 4)
