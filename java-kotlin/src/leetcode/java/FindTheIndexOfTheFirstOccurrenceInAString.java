package leetcode.java;

import java.util.Arrays;

public class FindTheIndexOfTheFirstOccurrenceInAString {
  /*
      haystack: abababcabc needle: ababc
                lr

      ababc
      00120
      abcabcabc
      000123456
      aaaaaaa
      0123456
      f(i): longest length that prefix of needle[:i+1] which is also suffix of needle[:i+1]

      ababababbc
      ababc
        ababc

      abcabcabdabcabc
      abcabcabc
      000123456
         abcabc
            abc
              a
               abcabc
      aabaaabaaac

      aabaaac
   */
  public int strStr(String haystack, String needle) {
    if (haystack.length() < needle.length()) {
      return -1;
    }

    int[] lps = this.longestPrefixWhichIsSuffix(needle);

    int i = 0; // needle index
    for (int j = 0; j<haystack.length(); j++) {
      while (i > 0 && needle.charAt(i) != haystack.charAt(j)) {
        i = lps[i - 1];
      }

      if (needle.charAt(i) == haystack.charAt(j)) {
        i++;
      }

      if (i == needle.length()) {
        return j - i + 1;
      }
    }


    return -1;
  }

  /*
      issipi
      000101

      abacabab
      00101232
   */
  private int[] longestPrefixWhichIsSuffix(String s) {
    int[] lps = new int[s.length()];

    int pre = 0;
    for (int i = 1; i<s.length(); i++) {
      while (pre > 0 && s.charAt(i) != s.charAt(pre)) {
        pre = lps[pre - 1];
      }

      if (s.charAt(pre) == s.charAt(i)) {
        pre++;
        lps[i] = pre;
      }
    }

    return lps;
  }

  public static void main(String[] args){

    System.out.println(Arrays.toString(new FindTheIndexOfTheFirstOccurrenceInAString().longestPrefixWhichIsSuffix("ababc")));
    System.out.println(Arrays.toString(new FindTheIndexOfTheFirstOccurrenceInAString().longestPrefixWhichIsSuffix("abcabcabc")));
  }
}

