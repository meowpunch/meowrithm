package leetcode.java;

public class ReorganizeString {
    /*
    aaaabc

    aaaabbc

    bcb
 */
    public String reorganizeString(String s) {
        // preprocess
        int[] bucket = new int[26];

        for (char c: s.toCharArray()) {
            int i = c - 'a';
            bucket[i]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<s.length(); i++) {

            int maxIndex = 0;
            int maxCount = 0;
            for (int j = 0; j<26; j++) {
                if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == (char) (j + 'a')) {
                    continue;
                }

                if (maxCount < bucket[j]) {
                    maxIndex = j;
                    maxCount = bucket[j];
                }
            }

            if (maxCount == 0) continue;
            sb.append((char) (maxIndex + 'a'));
            bucket[maxIndex]--;
        }

        return sb.length() == s.length() ? sb.toString(): "";
    }
}
