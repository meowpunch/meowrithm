package Codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PermMissingElem {

    /**
     * length of arr, n is [0, 100,000]
     * memoize summation of elements.
     *
     * (n + 1)n / 2 - summation = the missing element.
     *
     * int 4bytes 2^32 -> 2 * 10^9 (1 bit is a sign bit) 2,000,000,000
     *
     * @param arr
     * @return
     */
    public int solutionStream(int[] arr) {
        long maxNumber = arr.length + 1;
        long summation = Arrays.stream(arr).parallel().mapToLong(i -> (long) i).sum();

        return (int) ((maxNumber) * (maxNumber + 1) / 2 - summation);
    }

    public  int solution(int[] A) {
        long summation = 0;
        for (int a: A) {
            summation += a;
        }
        long maxNumber = A.length + 1;

        return (int) ((maxNumber + 1) * maxNumber / 2 - summation);
    }

    /**
     * let size of arr be n
     * the range of each element in arr is [1, n+1]
     *
     * Using HashMap, memoize the occurrence of each element.
     *
     * Time/Space: O(n)/O(n)
     * @param arr
     * @return missing element
     */
    public int solution2(int[] arr) {
        // init
        Map<Integer, Boolean> occurrence = new HashMap<>();

        // O(n)
        for (int a: arr) {
            occurrence.put(a, true);
        }

        // O(n)
        return IntStream.rangeClosed(1, arr.length + 1)
                .filter(i -> !occurrence.getOrDefault(i, false))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


    // test
    public static void main(String[] args) {
        System.out.println(new PermMissingElem().solution(new int[]{1,2,3}));
        System.out.println(new PermMissingElem().solution(new int[]{1,2,5,3}));
        System.out.println(IntStream.rangeClosed(0, 1000000).sum());
    }
}
