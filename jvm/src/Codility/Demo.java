package Codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Demo {

    public int solution(int[] A) {
        Map<Integer, Boolean> mem = new HashMap<>();

        Arrays.stream(A).forEach(a -> {
            if (!mem.getOrDefault(a, false)) {
                mem.put(a, true);
            }
        });

        return IntStream.rangeClosed(1, A.length + 1)
                .filter(i -> !mem.getOrDefault(i, false))
                .min()
                .orElseThrow(IllegalArgumentException::new);
    }

    public static void main(String[] args) {
        System.out.println(new Demo().solution(new int[]{1, 2, 3}));
    }
}
