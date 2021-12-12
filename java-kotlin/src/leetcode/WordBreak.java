package leetcode;

import java.util.*;

public class WordBreak {

    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(new WordBreak().wordBreak("aaaaaaa", List.of("aa", "aaaa", "aaa")));
    }

    /*
        a a a a a a a [aaaa, aaa, aa]

        a a
            a a
                a a
                a a a

            a a a
                  ...
            a a a a
                  ...
     */
    public boolean wordBreak(String s, List<String> wordDict) {
//        return bruteforce(s, wordDict);
        return bruteforceWithSet(s, new HashSet<>(wordDict));
//        return dfs(s, wordDict, new HashMap<String, Boolean>());
//        return dp(s, wordDict);
//        return dpWithSet(s, wordDict);
    }

    // TLE
    public boolean bruteforce(String s, List<String> wordDict) {
        if (s.length() == 0) return true;

        for (int i = 0; i < s.length(); i++)
            if (wordDict.contains(s.substring(0, i + 1)))
                if (bruteforce(s.substring(i + 1), wordDict)) return true;

        return false;
    }


    // TLE
    public boolean bruteforceWithSet(String s, Set<String> wordDict) {
        if (s.length() == 0) return true;

        for (int i = 0; i < s.length(); i++)
            if (wordDict.contains(s.substring(0, i + 1)))
                if (bruteforceWithSet(s.substring(i + 1), wordDict)) return true;

        return false;
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
                if (i - j >= -1) {
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

        cat cats dog astdog
             root
            c   d
            a   o
            t   g
            s

            catsdog
           01234567

           dp: [f, f, t, t, f, t]

     */
    public boolean dpWithTrie(String s, List<String> wordDict) {
        throw new UnsupportedOperationException();
    }

}
