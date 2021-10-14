package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
    Origin: `https://leetcode.com/problems/concatenated-words/`
    related to `https://leetcode.com/problems/word-break/`
 */
public class ConcatenatedSWords {

    public static void main(String[] args) {
        System.out.println(
                new ConcatenatedSWords()
                        .findAllConcatenatedWordsInADict(
                                new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}
                        ));
    }

    /*
        for word <- words
            if isConcatenated
        yield word
     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
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
