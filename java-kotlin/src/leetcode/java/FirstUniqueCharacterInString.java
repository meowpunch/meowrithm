package leetcode.java;

import java.util.Arrays;

public class FirstUniqueCharacterInString {

    /*
        time/space O(N)/O(1)
        int Array is better than HashMap

        space 26, # of alphabet characters
     */
    public int firstUniqChar(String s) {
        final int[] count = new int[26];
//        Arrays.fill(count, 0);

        // N
        for (char c : s.toCharArray()) count[c - 'a'] += 1;

        // N
        for (int i = 0; i < s.length(); i++) if (count[s.charAt(i) - 'a'] == 1) return i;

        return -1;
    }
}
