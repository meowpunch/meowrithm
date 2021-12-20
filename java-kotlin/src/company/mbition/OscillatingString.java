package company.mbition;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OscillatingString {
    public static void main(String[] args) {
//        System.out.println(
//                changedSort("ababzy")
//        );
//        System.out.println(
//                changedSort("babcbb")
//        );
//        System.out.println(
//                changedSort("zafb")
//        );
//        System.out.println(
//                changedSort("azzzaa") // azazaz
//        );

        System.out.println(
                advancedSort("azzzazaa") // azazaz
        );
        System.out.println(
                advancedSort("aaabbbbccc") // abcbabcbacb
        );
    }


    /*
            e.g.
                aaabbbccc -> abcbabcac
                babcbb -> abcbbb

            let the length of s be N.

            1. one String Builder and two Stack: O(N^2)
                worst case:  aaaaabbbbb -> ababababab

            2. the number of the lowercase alphabet is 26, which is constant
                I can solve it in 26 * N

            aaabbbbccc
            a: 3, b: 4, c: 3
            a b c
     */
    public static String changedSort(String s) {
        final StringBuilder sb = new StringBuilder();
        Stack<Character> oneStk = new Stack<>();
        Stack<Character> twoStk = new Stack<>();

        s.chars().mapToObj(i -> (char) i).sorted(Collections.reverseOrder())
                .forEach(oneStk::push);

        char prev = 'a' - 1;
        while (!oneStk.empty()) {

            // step 2
            while (!oneStk.empty()) {
                final Character c = oneStk.pop();
                if (c > prev) sb.append(c);
                else {
                    twoStk.push(c);
                }

                prev = c;
            }

            // step 4
            while (!twoStk.empty()) {
                final Character c = twoStk.pop();
                if (c < prev) sb.append(c);
                else {
                    oneStk.push(c);
                }

                prev = c;
            }

            // step 6
            if (oneStk.stream().distinct().count() == 1) {
                while (!oneStk.empty()) sb.append(oneStk.pop());
            }
        }

        return sb.toString();
    }


    public static String advancedSort(String s) {

        final int[] occurence = new int[26];
        final StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) occurence[c - 'a'] += 1;

        int count = 0;
        for (int o : occurence) if (o > 0) count++;

        int prev = -1;
        while (count > 0) {
            // step 2
            for (int c = 0; c < occurence.length; c++) {
                if (occurence[c] > 0 && c > prev) {
                    sb.append((char) (c + 'a'));
                    occurence[c]--;
                    if (occurence[c] == 0) count--;

                    prev = c;
                }
            }

            // step 6
            if (count > 1) {
                // step 4
                for (int c = occurence.length - 1; c >= 0; c--)
                    if (occurence[c] > 0 && c < prev) {
                        sb.append((char) (c + 'a'));
                        occurence[c]--;
                        if (occurence[c] == 0) count--;

                        prev = c;
                    }
            }

            // step 6
            if (count == 1) {
                for (int c = occurence.length - 1; c >= 0; c--) {
                    if (occurence[c] > 0)
                        while (occurence[c] > 0) {
                            sb.append((char) (c + 'a'));
                            occurence[c]--;
                        }

                    count = 0;
                }
            }
        }

        return sb.toString();
    }
}
