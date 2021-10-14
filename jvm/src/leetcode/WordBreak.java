package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(
                new WordBreak().wordBreak(
                        "leetcode",
                        List.of("leet", "code")
                )
        );
    }

    public boolean wordBreak(String s, List<String> wordDict) {
//        return dfs(s, wordDict, new HashMap<String, Boolean>());
//        return dp(s, wordDict);
        return dpWithSet(s, wordDict);
    }

    /*
        f(i) <- f(i - size of word) + word in wordDict, (0 <= i < s.size)
        O(s * wordDict * avg length of word in wordDict)

        e.g. leetcode
             01234567
     */
    public boolean dp(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String w : wordDict) {
                int j = w.length();
                if (i - j >= - 1) {
                    if ((i - j == -1 || f[i - j]) && s.substring(i - j + 1).startsWith(w)) f[i] = true;
                }
            }
        }

        return f[s.length() - 1];
    }

    /*
       O(s * s * s)

       e.g. l e e t c o d e
          0 1 2 3 4 5 6 7 8
    */
    public boolean dpWithSet(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        Set<String> wordSet = new HashSet<>(wordDict);

        for (int i = 1; i <= s.length(); i++) {
            // j
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && wordSet.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    /*
        Trie
     */
    public boolean dpWithTrie(String s, List<String> wordDict) {

    }

    /*
        DFS
        HashMap<String, Boolean>
        postfix -> true/false
    */
    public boolean dfs(String s, List<String> wordDict, Map<String, Boolean> mem) {
        if (s.length() == 0) return true;
        else {
            for (String prefix : wordDict) {
                if (s.startsWith(prefix)) {
                    String postfix = s.substring(prefix.length());
                    if (mem.get(postfix)) return true;
                    else {
                        boolean p = dfs(
                                s.substring(prefix.length()),
                                wordDict,
                                mem
                        );
                        mem.put(postfix, p);
                        if (p) return true;
                    }
                }
            }

            return false;
        }
    }
}
