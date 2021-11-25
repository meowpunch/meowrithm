package codility;

public class MaxNonOverlappingSegments {
    /**
     *  Greed Algorithm - choosing the local best
     *
     *  Iterate
     *  1. choose a segment having the minimum ending point. (Already sorted)
     *  2. remove the chose segment and other segments overlapping with the chose segment.
     */
    public int solution(int[] A, int[] B) {
        int count = 0;
        int currIndex = 0;

        while (currIndex < A.length) {
            // 1. choose a segment
            final int minEnding = B[currIndex];
            count += 1;

            // 2. remove overlapping
            while (currIndex < A.length && A[currIndex] <= minEnding) currIndex += 1;
        }


        return count;
    }
}
