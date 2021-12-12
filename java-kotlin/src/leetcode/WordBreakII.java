package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WordBreakII {
    public static void main(String[] args) {
        System.out.println(new WordBreakII().wordBreak("catsanddog", List.of("cat","cats","and","sand","dog")));
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
        if (s.length() == 0) ans.add(String.join(" ", acc));

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                acc.push(word);
                bruteforce(s.substring(word.length()), acc, ans, wordDict);
                acc.pop();
            }
        }
    }
}
