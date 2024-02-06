package leetcode.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class WordBreakII {
    public static void main(String[] args) {
        System.out.println(new WordBreakII().wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
    }

    /*
    wordDict.length <= 1000: N
    s.length <= 20: L
    wordDict[i].length <= 10: L

    Think in perspective s than wordDict


    -- loop wordDict
    for (String word: wordDict) {
        s.hasPrefix(word)
        int i = s.indexOf(word)
        wordBreak(s.subsstring(i), wordDict)
    }
    N^M

    -- loop s

    catsanddog

    "c" check if "c" is in wordDict

    "cat" check if "cat" is in wordDict

    wordSet = new HashSet<>(wordDict);
    - check if s[:i+1] is in wordDict
        wordBreak(s[i+1], wordDict)
    - return s[:i+1] X wordBreak(s[i+1], wordDict)

    M^M


    pineapplepenapple
    ["apple","pen","applepen","pine","pineapple"]

    pine apple pen apple
 */
    public List<String> wordBreak2024(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        List<String> words = new ArrayList<>();

        for (int i = 0; i<s.length(); i++) {
            String prefix = s.substring(0, i+1);
            if (wordSet.contains(prefix)) {
                String suffix = s.substring(i+1);

                if (suffix.isEmpty()) {
                    words.add(prefix);
                } else {
                    for (String subWord: wordBreak(suffix, wordDict)) {
                        words.add(prefix + " " + subWord);
                    }
                }
            }
        }

        return words;
    }

    /*
        s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        bruteforce(s, new Stack<>(), ans, wordDict);
        return ans;
    }


    /*
        bruteforce + dfs + backtracking
     */
    public void bruteforce(String s, Stack<String> acc, List<String> ans, List<String> wordDict) {
        if (s.isEmpty()) ans.add(String.join(" ", acc));

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                acc.push(word);
                bruteforce(s.substring(word.length()), acc, ans, wordDict);
                acc.pop();
            }
        }
    }
}
