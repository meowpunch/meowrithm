class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        table = dict()

        for string in strs:
            sorted_str = ''.join(sorted(string))

            try:
                table[sorted_str].append(string)
            except KeyError:
                table[sorted_str] = [string]

        return list(table.values())