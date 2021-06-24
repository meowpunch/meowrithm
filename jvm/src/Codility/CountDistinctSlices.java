package Codility;

import java.util.Arrays;
import java.util.HashMap;

public class CountDistinctSlices {
    /**
     *  1, 2, 3, 1, 4, 5
     *
     *  1 -> 3 -> 6 -> 9 -> 13 -> 18
     */
    public int solution(int M, int[] A) {
        // value: index
        final HashMap<Integer, Integer> occurrence = new HashMap<>();
        final int N = A.length;
        int tail = 0; int head = 0;
        int count = 0;

        while (head < N) {
//            System.out.println(count);
            final int headValue = A[head];
            final int duplicateIndex = occurrence.getOrDefault(headValue, -1);

            occurrence.put(headValue, head);
            if (duplicateIndex != -1) {
                tail = Math.max(tail, duplicateIndex + 1);
            }

//            System.out.printf("%s %s\n\n", head, tail);
            count += head - tail + 1;
            if (count > 1000000000) return 1000000000;

            head += 1;
        }

        return count;
    }

    public int solution2(int M, int[] A) {
        int totalSlices = 0;
        boolean[] inCurrentSlice = new boolean[M + 1];
        Arrays.fill(inCurrentSlice, false);
        int head = 0;
        for (int tail = 0; tail < A.length; tail++) {
            while (head < A.length && !inCurrentSlice[A[head]]) {
                inCurrentSlice[A[head]] = true;
                totalSlices += (head - tail) + 1;
                head += 1;
                if (totalSlices > 1000000000)
                    totalSlices = 1000000000;
            }
            inCurrentSlice[A[tail]] = false;
        }
        return totalSlices;
    }


    /**
     *  nC2 + nC1 = n+1C2
     *  (n + 1) * n / 2
     */
    private int countNumOfCases(int n) {
        return (n + 1) * n / 2;
    }


    public static void main(String[] args) {
        //                                                                    1  3  6  10 13 17 20 24 29 30 32 35 39
        System.out.println(new CountDistinctSlices().solution(9, new int[]{2, 4, 1, 7, 4, 9, 7, 3, 5, 5, 8, 7, 1}));
        System.out.println(new CountDistinctSlices().solution(6, new int[]{3, 4, 5, 5, 2}));
    }
}
