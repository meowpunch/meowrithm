package leetcode.java;

import java.util.HashSet;

public class LongestConsecutiveSequenceJava {
    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequenceJava().longestConsecutive(
                new int[]{100, 4, 200, 1, 3, 2}
        ));

        System.out.println(new LongestConsecutiveSequenceJava().bruteforce(
                new int[]{100, 4, 200, 1, 3, 2}
        ));
    }

    /*
        time: O(n^3)
            brute force

        time: O(nlogn)
            1. sorting the array in ascending order
            2. loop and find ans


        // brute force + hashset (memoization) + intelligent sequence (only check for minimum value of consequence)
        time: O(n)
            1. array to HashSet
            2. check only minimum value of consequence

     */
    public int longestConsecutive(int[] nums) {
        // array to HashSet
        HashSet<Integer> m = new HashSet<>();
        for (int n : nums) m.add(n);

        int maxLength = 0;
        for (Integer v : m) {
            int tempLength = 1;

            // check only minimum value of consecutive subsequence
            if (!m.contains(v - 1)) {
                int tv = v + 1;
                while (m.contains(tv)) {
                    tempLength++;
                    tv++;
                }

                maxLength = Math.max(tempLength, maxLength);
            }
        }

        return maxLength;
    }

    public boolean arrayContains(int[] arr, int target) {
        for (int v : arr) if (v == target) return true;
        return false;
    }

    public int bruteforce(int[] nums) {
        int maxLength = 0;
        for (int v : nums) {
            int tv = v + 1;
            int tempLength = 1;


            /* improve with checking only minimum value of subsequence */
            while (arrayContains(nums, tv) /* improve with hashset */) {
                tempLength++;
                tv++;
            }

            maxLength = Math.max(maxLength, tempLength);
        }

        return maxLength;
    }
}


