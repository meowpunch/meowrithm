package company.amazon;

/*
    https://leetcode.com/problems/word-break/description/

    Given an input string and a list of words (dictionary),
    write a function that can determine if the input string can be composed
    as a strict concatenation of dictionary words.

    Examples:
    s, wordList
    "anothernewyear", ["another", "new"] => false
    "anothernewyear", ["another", "new", "year", "foo"] => true

    # The word can be used multiple time
    # Empty of word would return false
    # wordList has unique words
    #
    # s < 100 M
    # wordList < 10,000 N
    # M << N
    #
    # - loop the word in a list of words
    # - s.prefix(word)
    #
    #
    # - loop in s
    #   prefix substring(0, i+1)
    #   wordSet.contains(prefix)
    #   stringIsPossibleComposbedByWordSet(suffix, wordSet)
    #
    #
    #   "anothernewyear", ["another", "new", "year", "foo"] => true
    #   "anothernewyear", {"another", "new", "year", "foo"}
    #
    #   a
    #   an
    #   ano
    #   ...
    #   another
    #       set.contains(another)
    #
    #           "newyear", {"another", "new", "year", "foo"}
    #
    #           "year", {"another", "new", "year", "foo"}
    #
    #   "anothernewyear", ["another", "new"] => false
    #       "newyear", ["another", "new"]
    #           "year", ["another", "new"]
    #           y
    #           ye
    #           yea
    #           year
*/


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringComposition2024 {


    /*

        "a {}"
     */
    public boolean stringIsPossibleComposedByWordList(String s, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        return stringIsPossibleComposedByWordSet(s, wordSet);
    }

    private boolean stringIsPossibleComposedByWordSet(String s, Set<String> wordSet) {
        if(wordSet.contains(s)){
            return true;
        }

        boolean possiblity = false;

        for (int i = 0; i<s.length(); i++) {
            if (wordSet.contains(s.substring(0, i+1))){
                if (stringIsPossibleComposedByWordSet(s.substring(i+1), wordSet)) {
                    possiblity = true;
                }
            }
        }

        return possiblity;
    }
}
