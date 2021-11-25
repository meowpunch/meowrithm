package others;

import java.util.Arrays;

public class BinarySearch {
    /**
     * @param A
     * @param target
     * @return the largest element <= target
     */
    public int solution(int A[], int target) {
        final int L = A.length;
        if (L == 1) return A[0];
//        System.out.printf("%s %s %s\n", Arrays.hashCode(A), L, L / 2);
        final int mid = L / 2;

        // left side
        if (A[mid] > target) return solution(Arrays.copyOfRange(A, 0, mid), target);
        // right side
        else return solution(Arrays.copyOfRange(A, mid, L), target);
    }

    public int solution2(int A[], int str, int end, int target) {
        if (str == end) return str;
        System.out.println(Arrays.hashCode(A));
        final int mid = (end + str) / 2;

        // left side
        if (A[mid] > target) return solution2(A, str, mid - 1, target);
        // right side
        else return solution2(A, mid, end, target);
    }

    public static void main(String[] args) {
        // expected answer - 8
        System.out.println(new BinarySearch().solution(new int[]{1,2,4,6,8,11,13}, 10));

        // expected answer - 4
        System.out.println(new BinarySearch().solution2(new int[]{1,2,4,6,8,11,13}, 0, 6, 10));
    }
}
