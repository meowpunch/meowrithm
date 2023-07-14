package leetcode.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

  /*
      O(N^3) - brute force
          two pointers, all combination for s.substring(l, r + 1), l < r -> O(N^2)
          check if the substring contains at most two distinct char -> O(N)

      O(N^2) - window sliding
          sliding window
              increasing right index, if it's not valid then move left index

          s = "ccaabbb"

          "c"

          "cc"

          "cca"

          "ccaa"

          "ccaab" not valid

          "caabb" not valid

          "aabbb"

      O(N) - window sliding with HashMap counter
          * How to keep distinct characters *

          s = "ccaabbb"

          "c"
          {c: 1}

          "cc"
          {c: 2}

          "cca"
          {c: 2, a: 1}

          "ccaa"
          {c: 2, a: 2}

          "ccaab" not valid
          {c: 2, a: 2, b: 1}

          "caabb" not valid
          {c: 1, a: 2, b: 2}


          "aabbb"
          {a: 2, b: 3}
   */
  public int lengthOfLongestSubstringTwoDistinct(String s) {
    var l = 0;
    var res = 0;
    final var charToCount = new HashMap<Character, Integer>();

    for (var r = 0; r < s.length(); r++) {
      final var rightMostElement = s.charAt(r);
      // increaseOneForRIghtMostElement();
      charToCount.put(rightMostElement, charToCount.getOrDefault(rightMostElement, 0) + 1);

      if (containsAtMostTwoDistinctCharacters(charToCount)) {
        if (r - l + 1 > res) {
          res = r - l + 1;
        }
      } else {
        final var leftMostElement = s.charAt(l);
        // decreaseOneForLeftMostElement();
        charToCount.put(leftMostElement, charToCount.getOrDefault(leftMostElement, 0) - 1);
        l++;
      }
    }

    return res;
  }

  private boolean containsAtMostTwoDistinctCharacters(Map<Character, Integer> charToCount) {
    return charToCount.values().stream().filter(i -> i > 0).count() <= 2;
  }

  public int lengthOfLongestSubstringTwoDistinctNotOptimized(String s) {
    var l = 0;
    var res = 0;
    for (var r = 0; r < s.length(); r++) {
      if (containsAtMostTwoDistinctCharacters(s.substring(l, r + 1))) {
        if (r - l + 1 > res) {
          res = r - l + 1;
        }
      } else {
        l++;
      }
    }

    return res;
  }

  // O(N)
  private boolean containsAtMostTwoDistinctCharacters(String subString) {
    final var charSet = new HashSet<Character>();
    for (char c : subString.toCharArray()) {
      charSet.add(c);
      if (charSet.size() > 2) {
        return false;
      }
    }

    return true;
  }
}
