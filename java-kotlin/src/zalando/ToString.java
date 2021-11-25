package zalando;

import java.util.ArrayList;
import java.util.List;

public class ToString {

    public static void main(String[] args) {
        System.out.println(
                new ToString().toString(
                        List.of(
                            List.of("one", "two", "three"),
                            List.of("four", "five"),
                            List.of("six")
                        )
                )
        );
    }

    /*
        input
        [
            ["one", "two", "three"],
            ["four", "five"],
            ["six"]
        ]

        output
        | one  | two  | three |
        | four | five |
        | six  |
     */
    public String toString(List<List<String>> input) {

        final List<Integer> longestLengthByColumn = new ArrayList<>();
        for (List<String> row : input) {
            for (int i = 0; i < row.size(); i++) {
                final int length = row.get(i).length();
                try {
                    longestLengthByColumn.set(i, Math.max(longestLengthByColumn.get(i), length));
                } catch (IndexOutOfBoundsException e) {
                    longestLengthByColumn.add(length);
                }
            }
        }

        final StringBuilder sb = new StringBuilder();
        for (List<String> row : input) {
            sb.append("|");
            for (int i = 0; i < row.size(); i++) {
                sb.append(String.format(" %-" + longestLengthByColumn.get(i) + "s |", row.get(i)));
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}