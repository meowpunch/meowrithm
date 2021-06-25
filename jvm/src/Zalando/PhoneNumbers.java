package Zalando;

import java.util.Comparator;
import java.util.stream.IntStream;

public class PhoneNumbers {
    /**
     * @param A
     * @param B
     * @param P
     * @return
     */
    public String solution(String[] A, String[] B, String P) {
        final int N = A.length;

        return IntStream.range(0, N)
                .filter(i -> B[i].contains(P))
                .mapToObj(i -> A[i])
                .min(String::compareTo)
                .orElse("NO CONTACT");
    }

}
