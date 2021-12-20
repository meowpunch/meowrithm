package company.zalando;

import java.util.Arrays;

public class RollDice {
    /**
     *  Let N be the size of A
     *  Let B[] be the returned array (size: F, F <= sum(B) <= 6*F)
     *
     *  M = (sum(A) + sum(B)) / (N + F)
     *  sum(B) = M*(N + F) - sum(A)
     *
     *  0. calculate sum(B) = M*(N + F) - sum(A)
     *      -> O(N), sum A
     *  1. validate the range, F <= sum(B) <= 6*F
     *      -> O(1)
     *  2. if there is the possible result, return the array. otherwise, return [0]
     *      -> O(F), 0 <= remainder < F
     *
     *  Time/Space: linear O(max(N, F)), linear O(F)
     *
     * @param A: the array of the remembered rolls, the length N
     * @param F: the length of the forgotten rolls
     * @param M: the mean of all the results
     * @return the array of the forgotten rolls or [0]
     */
    public int[] solution(int[] A, int F, int M) {
        final int N = A.length;
        int sumB = M * (N + F) - Arrays.stream(A).sum();

        if (isPossibleRange(sumB, F)) {
//            final int quotient = sumB / F;
//            final int remainder = sumB % F;
            final int[] result = new int[F];

            // iterate twice
            // fill result
//            Arrays.fill(result, quotient);
//            for (int i = 0; i < remainder; i++) result[i] += 1;
            // iterate once
            for (int i = 0; i < F; i++) {
                result[i] = sumB/(F - i);
                sumB -= result[i];
            }
            return result;
        } else {
            // there is no possible result
            return new int[]{0};
        }
    }

    // In the case of the possible range, F <= sum(B) <= 6*F
    private boolean isPossibleRange(int sumB, int F) {
        return F <= sumB && sumB <= 6*F;
    }

    public static void main(String[] args) {
        int[] ans = new RollDice().solution(new int[]{1,4,6}, 4, 3);
        for (int a: ans) System.out.println(a);
    }
}
