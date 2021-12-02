package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /*

        s = "ADOBECODEBANC", t = "ABC"

        D A D O B E C O D E B A  N  C
        0 1 2 3 4 5 6 7 8 9 10 11 12


        expand
        i           j
          reduce
          i         j
            expand
            i                 j
                    reduce
                    i         j
                       expand
                       i            j
                             reduce
                             i      j
                               expand
                               i    done

     */
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        else {
            // count characters of string t
            Map<Character, Integer> m = new HashMap<>();
            for (char c : t.toCharArray()) m.put(c, m.getOrDefault(c, 0) + 1);

            int i = 0;
            int j = 0;
            int mi = -1;
            int mj = -1;
            int count = t.length();

            while (j < s.length()) {
                // expand window by j
                while (j < s.length() && count > 0) {
                    final char c = s.charAt(j);
                    final int o = m.getOrDefault(c, 0);
                    if (o > 0) count--;

                    m.put(c, o - 1);
                    j++;
                }
                j--;

                // reduce window by i
                while (i <= j && count == 0) {
                    final char c = s.charAt(i);
                    final int o = m.get(c);


                    if (o == 0) {
                        if (mi == -1 || j - i < mj - mi) {
                            mi = i;
                            mj = j;
                        }

                        count++;
                    }

                    m.put(c, o + 1);
                    i++;
                }
                j++;
            }

            if (mi == -1) return "";
            else return s.substring(mi, mj + 1);

        }
    }

}
