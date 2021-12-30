package company.sap;

import java.util.HashMap;
import java.util.Map;

public class FirstUnique {
    public static void main(String[] args) {
        System.out.println(new FirstUnique().firstUnique("supercalifragilisticexpialidocious"));
    }

    /*
        input: supercalifragilisticexpialidocious
        output: f
    */
    public Character firstUnique(String input) {
        // the number of occurrence of character
        final int[] o = new int[26];

        for (char c: input.toCharArray()) o[c - 'a'] += 1;

        for (char c: input.toCharArray()) if(o[c - 'a'] == 1) return c;

        return null;
    }

    public Character firstUniqueWithHashMap(String input) {
        // Char -> the number of occurrence of character
        final Map<Character, Integer> m = new HashMap<>();

        for (char c: input.toCharArray()) m.put(c, m.getOrDefault(c, 0) + 1);

        for (char c: input.toCharArray()) if(m.getOrDefault(c, 0) == 1) return c;

        return null;
    }
}
