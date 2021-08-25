package others;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mem = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (mem.containsKey(diff)) {
                return new int[] { mem.get(diff), i };
            } else {
                mem.put(nums[i], i);
            }
        }

        throw new IllegalArgumentException("No solution");
    }
}