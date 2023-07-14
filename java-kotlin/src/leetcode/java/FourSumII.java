package leetcode.java;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class FourSumII {
    public static void main(String[] args) {
        System.out.println(FourSumII.fourSumCount(
                new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}
        ));
    }

    /*
     * four nested loop O(n^4)
     * -> 200^4 = 16 * 100^4 = 1,600,000,000
     *
     * Dynamic programming O(n^2)
     */
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // to store occurrence
        Map<Integer, Integer> occurence = new HashMap<>();

        for (int i: nums1) {
            for (int j: nums2) {
                final int sum = i + j;
                occurence.put(sum, occurence.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int i: nums3) {
            for (int j: nums4) {
                final int sum = i + j;
                count += occurence.getOrDefault(-sum, 0);
            }
        }

        return count;
    }
}
