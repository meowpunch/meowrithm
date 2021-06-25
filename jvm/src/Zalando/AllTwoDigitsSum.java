package Zalando;

import java.util.Arrays;

public class AllTwoDigitsSum {
    /**
     * 1. filter - exclude not two digit
     * 2. reduce - sum
     * <p>
     * - In case of empty array, return 0
     * - Following the assumes, don't worry a overflow of sum
     *
     * @param A : given an array A consisting of N integers,
     *          assuming N's range [0, 100,000] and each ele of A is an integer within [-2147483648, 2147483647]
     * @return : the sum of all two digits numbers
     */
    public int solution(int[] A) {
        if (A == null) throw new IllegalArgumentException("Input should be consist of int elements and the size is [0, 100000]");
        return Arrays.stream(A)//.parallel()
                .filter(e -> (-100 < e && e <= -10) || (10 <= e && e < 100))
                .sum();
    }

    public static void main(String[] args) {
        new AllTwoDigitsSum().solution(null);
    }
}
