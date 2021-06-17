package Codility;

public class CountDiv {
    /**
     *  let the size of [A, B] be N
     *  Prefix Sum, Time/Space: O(N), O(1)
     *  Mathematical, Time/Space: O(1), O(1)
     *
     *  6, 7, 8, 9, 10, 11
     *
     *  11 / 2 = 5
     *  (6 - 1) / 2 = 2
     */
    public int solution(int A, int B, int K) {
        return (int) Math.round(Math.floor(B / (double) K) - Math.floor((A - 1) / (double)K));
    }
}
