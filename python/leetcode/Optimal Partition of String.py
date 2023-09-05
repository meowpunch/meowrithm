class Solution:

    #   partition - f(i - 1), that is optimal partition until i - 1 idx of s
    #   s[i]
    #   - create new substring containing s[i] and add it ot partition
    #   - add s[i] to the last substring of partition
    #
    #   assume that we do first option even if second option is possible.
    #   Then there is no benefit ot get minimal length of partition,
    #   because new substring loses opportunity
    #   to have s[i] character in the coming index (idx > i)
    #   It's the reason why we could do greedy strategy.
    #   That is if second option is possible, we should do.
    #
    #   we can keep the set of character of the last substring
    #   Time: O(1) Space: O(N)
    def partitionString(self, s: str) -> int:
        set_of_character_of_last_substring = set()
        length_of_optimal_partition = 1

        for c in s:
            if c in set_of_character_of_last_substring:
                length_of_optimal_partition += 1
                set_of_character_of_last_substring = {c}
            else:
                set_of_character_of_last_substring.add(c)

        return length_of_optimal_partition

    #   "abacaba"
    #
    #   "a" "b" "c"
    #           "bc"
    #       "ab"
    #
    def dfs(self, s: str, partition: list[str]) -> int:
        if not s:
            return len(partition)
        else:
            rest, tail = s[:-1], s[-1]
            tail_substring = partition[-1]

            if tail not in tail_substring:
                a = self.dfs(rest, partition.copy() + [tail])
                p = partition.copy()
                p.remove(tail_substring)
                p.append(tail_substring + tail)
                b = self.dfs(rest, p)
                return min(a, b)
            else:
                return self.dfs(rest, partition.copy() + [tail])


if __name__ == '__main__':
    s = "abc"
    print(s[:-1], s[-1])
    s = "a"
    print(s[:-1], s[-1])
    if not s[:-1]:
        print(s[-1])
    # s = ""
    # print(s[-1])

    print(["", "123"] + ["4"])

    print(Solution().partitionString("abacaba"))
    print(Solution().partitionString("sssssss"))
