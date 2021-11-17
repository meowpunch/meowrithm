package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/*
    Origin: `https://leetcode.com/problems/concatenated-words/`
    related to `https://leetcode.com/problems/word-break/`
 */
public class ConcatenatedWords {

    public static void main(String[] args) {
        System.out.println(
                new ConcatenatedWords()
                        .findAllConcatenatedWordsInADict(
                                new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}
                        ));
    }


    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        return optimization(words);
//        return brutesForce(words);
    }


    /*
        words: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
        word: catsdogcats
     */
    private List<String> optimization(String[] words) {
        List<String> ans = new LinkedList<>();
        Set<String> wordSet = new HashSet<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word: words) {
            if(!wordSet.isEmpty() && isConcatenatedWithDP(word, wordSet)) ans.add(word);

            wordSet.add(word);
        }

        return ans;
    }

    private boolean isConcatenatedWithDP(String word, Set<String> wordSet) {
        boolean[] f = new boolean[word.length() + 1];
        f[0] = true;

        for (int i = 1; i <= word.length(); i++) {
            // j
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && wordSet.contains(word.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[word.length()];
    }



    /*
        for word <- words
            if isConcatenated
        yield word
     */
    private List<String> brutesForce(String[] words) {
        if (words.length == 1) return Collections.emptyList();
        return Arrays.stream(words)
                .filter(w ->
                        isConcatenated(
                                w,
                                Arrays.stream(words).filter(x -> !x.equals(w)).collect(Collectors.toList())
                        ))
                .collect(Collectors.toList());
    }

    /*
        words: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
        word: catsdogcats

        prefix: cat
        catsdogcats.startWith("cat")
     */
    private boolean isConcatenated(String word, List<String> words) {
        if (word.length() == 0) return true;
        else {
            for (String prefix : words) {
                if (word.startsWith(prefix)) {
                    if (isConcatenated(
                            word.substring(prefix.length()),
                            words.stream().filter(w -> !w.equals(word)).collect(Collectors.toList())
                    )) return true;
                }
            }

            return false;
        }
    }


}
