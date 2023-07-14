package leetcode.kotlin;

public class LongestPalindromicSubstring {

  /*
      brute force - O(N^3)
          all combination of substring - O(N^2)
          check palindromic - O(N)

      DP
          f(i, j) represents if s.substring(i, j + 1) is palindromic or not
              if f(i + 1, j - 1) is true && s(i) == s(j) then f(i, j) is true
   */
  public String longestPalindrome(String s) {
    final var N = s.length();
    boolean[][] isPalindromic = new boolean[N][N];

    for (var i = 0; i < N; i++) {
      isPalindromic[i][i] = true;
    }

    var resLeftIndex = 0;
    var resRightIndex = 0;
    for (var i = 0; i < N - 1; i++) {
      if (s.charAt(i) == s.charAt(i + 1)) {
        isPalindromic[i][i + 1] = true;
        resLeftIndex = i;
        resRightIndex = i + 1;
      } else {
        isPalindromic[i][i + 1] = false;
      }
    }

    for (var diff = 2; diff < N; diff++) {
      for (var i = 0; i < N - diff; i++) {
        final var j = i + diff;

        if (s.charAt(i) == s.charAt(j) && isPalindromic[i + 1][j - 1]) {
          isPalindromic[i][j] = true;
          resLeftIndex = i;
          resRightIndex = j;
        }
      }
    }

    return s.substring(resLeftIndex, resRightIndex + 1);
  }
}
