package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
    System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
  }

    /*

        l leftIndex, r rightIndex


        * How to go through elements with sliding window *

        s = "abcabcbb"

        0, 0 "a"
        {a}

        0, 1 "ab"
        {a, b}

        0, 2 "abc"
        {a, b, c}

        0, 3 "abca"

        1, 4 "bcab"

        2, 5 "cabc"

        3, 6 "abcb"

        4, 7 "bcbb"

        s = "pwwkew"

        "p"
        {p}

        "pw"
        {p, w}

        "pww"
        {w}

        "wwk"

        "wke"

        "kew"
        ...


     */

  public int lengthOfLongestSubstring(String s) {

    var l = 0;
    var maxLength = 0;
    final var set = new HashSet<Character>();
    for (var r = 0; r < s.length(); r++) {
      if (set.contains(s.charAt(r))) {
        while (s.charAt(l) != s.charAt(r)) {
          set.remove(s.charAt(l));
          l++;
        }
        l++;
      } else {
        if (r - l + 1 > maxLength) {
          maxLength = r - l + 1;
        }
        set.add(s.charAt(r));
      }
    }
    return maxLength;
  }

  /*
     O(N^2)
   */
  public int lengthOfLongestSubstringWithHashSetForUniqueCharacter(String s) {
    var l = 0;
    var maxLength = 0;

    for (var r = 0; r < s.length(); r++) {
      if (containsUniqueCharacters(s.substring(l, r + 1))) {
        if (r - l + 1 > maxLength) {
          maxLength = r - l + 1;
        }
      } else {
        l++;
      }
    }
    return maxLength;
  }

  // O(N)
  private boolean containsUniqueCharacters(String substring) {
    HashSet<Character> occurredCharacter = new HashSet<>();
    for (char c : substring.toCharArray()) {
      if (occurredCharacter.contains(c)) {
        return false;
      } else {
        occurredCharacter.add(c);
      }
    }
    return true;
  }
}
