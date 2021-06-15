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
     * @param arr
     * @return
     */
    public int solution(int[] arr) {
        int n = arr.length;
        int summation = Arrays.stream(arr).sum();

        return (n + 2) * (n + 1) / 2 - summation;
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
    }
}
