package leetcode;

import java.util.HashSet;

public class FindTheDuplicateNumberJava {

    public int findDuplicate(int[] nums) {
        HashSet<Integer> m = new HashSet<>();

        for (int n: nums) {
            if (m.contains(n)) return n;
            else m.add(n);
        }

        throw new IllegalArgumentException();
    }
}
