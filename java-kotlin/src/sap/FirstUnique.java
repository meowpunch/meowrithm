package sap;

import java.util.HashMap;
import java.util.Map;

public class FirstUnique {

    /*
        input: supercalifragilisticexpialidocious
        output: f
    */

    public Character firstUnique(String input) {
        // Char -> whether is unique or not
        final Map<Character, Boolean> m = new HashMap<>();

        for (char c: input.toCharArray()) {
            if(m.getOrDefault(c, false)) {
                m.put(c, false);
            } else m.put(c, true);
        }

        for (char c: input.toCharArray()) {
            if(m.getOrDefault(c, false)) return c;
        }

        return null;
    }
}
