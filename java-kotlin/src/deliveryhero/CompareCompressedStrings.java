package deliveryhero;


import java.util.Arrays;
import java.util.stream.Stream;

public class CompareCompressedStrings {


    /*
        process of compress

        ap?le => ap1le
        a???e => a3le
        ??ple => 2ple
     */
    public static void main(String[] args) {
        CompareCompressedStrings ccs = new CompareCompressedStrings();

        Stream.of(
                Arrays.asList("2ple", "a3e"),
                Arrays.asList("app2", "2ple"),
                Arrays.asList("app2", "app3"),
                Arrays.asList("", "")
        ).map(
                l -> ccs.compare(l.get(0), l.get(1))
        ).forEach(System.out::println);
    }

    String decompress(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int i = Character.getNumericValue(c);

                while (i > 0) {
                    sb.append('?');
                    i--;
                }
            } else sb.append(c);
        }

        return sb.toString();
    }

    /**
     * e.g.
     * ap1le, a3e => true
     * 2ple, a3e => true
     * app2, app3 => false
     * "", "" => true
     *
     * ??ple, a???e
     *
     * @param s1 compressed String
     * @param s2 compressed String
     * @return check whether s1 could be equal to s2
     */
    boolean compare(String s1, String s2) {
        final String d1 = decompress(s1);
        final String d2 = decompress(s2);

        if (d1.length() != d2.length()) return false;
        else {
            for (int i = 0; i < d1.length(); i ++) {
                final char c1 = d1.charAt(i);
                final char c2 = d2.charAt(i);
                if (c1 == '?' || c2 == '?') continue;
                else if (c1 != c2) return false;
            }
            return true;
        }

    }

}
