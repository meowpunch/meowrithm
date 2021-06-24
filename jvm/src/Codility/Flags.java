package Codility;

import java.util.*;

public class Flags {
    /**
     *  Let the size of A be N
     *
     *  - search the peaks.
     *      [1, 3, 5, 10]
     *  - using floor(sqrt(1st idx of peak - last idx of peak))
     *      9 -> 3
     *
     *    x flags -> cover the range, x * (x - 1)
     *    1st idx of peak - last idx of peak > x^2 - x
     */
    public int solution(int[] A) {
        if (A.length < 3) return 0;

        final int[] peaks = findPeaks(A);

        int count = 1;
        while (canPlaceFlags(peaks, count)) count += 1;
        return count - 1;
    }

    private boolean canPlaceFlags(int[] peaks, int numFlags) {
        int count = 0;
        int prevPeak = -1;

        for (int currPeak : peaks) {
            if (prevPeak < 0 || (currPeak - prevPeak) >= numFlags) {
                if (count + 1 >= numFlags) return true;
                count += 1;
                prevPeak = currPeak;
            }
        }

        return false;
    }


    /**
     * return the indices of peaks
     */
    private int[] findPeaks(int[] A) {
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) peaks.add(i);
        }

        return peaks.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {

        System.out.println(new Flags().canPlaceFlags(new int[]{2, 4, 5}, 3));
        System.out.println(new Flags().canPlaceFlags(new int[]{2, 5, 8}, 3));
    }
}
