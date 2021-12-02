package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    /*

        s = "ADOBECODEBANC", t = "ABC"

        D A D O B E C O D E B A  N  C
        0 1 2 3 4 5 6 7 8 9 10 11 12

    start
    ij
    m - {A: 1, B: 1, C: 1}

        expand
        i           j
        m - {A: 0, B: 0, C: 0, D: -2, E: -1, O: -1}

          reduce
          i         j
          m - {A: 1, B: 0, C: 0, D: -1, E: -1, O: -1}

            expand
            i                 j
            m - {A: 0, B: -1, C: 0 ...}

                    reduce
                    i         j
                    m - {A: 0, B: 0, C: 1 ...}

                       expand
                       i            j
                       m - {A: 0, B: 0, C: 0 ...}
                             reduce
                             i      j
                             m - {A: 0, B: 1, C: 0 ...}

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
            int mLength = 0;
            int count = t.length();

            while (j < s.length()) {
                // expand window by j
                final char jc = s.charAt(j);
                final int jo = m.getOrDefault(jc, 0);
                if (jo > 0) count--;

                m.put(jc, jo - 1);

                // reduce window by i
                while (i <= j && count == 0) {
                    final char ic = s.charAt(i);
                    final int io = m.get(ic);

                    if (io == 0) {
                        // update
                        final int cLength = j - i + 1;
                        if (mLength == 0 || cLength < mLength) {
                            mi = i;
                            mj = j;
                            mLength = cLength;
                        }

                        count++;
                    }

                    m.put(ic, io + 1);
                    i++;
                }
                j++;
            }

            if (mi == -1) return "";
            else return s.substring(mi, mj + 1);

        }
    }

}
