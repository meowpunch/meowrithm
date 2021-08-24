package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(new Permutations().permutations(new int[]{1, 2, 3}));
        System.out.println(new Permutations().permute(new int[]{1, 2, 3}));
    }

    /**
     * time complexity O (N^2 * N!)
     */
    public List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // base case
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        for (int num : nums) {
            // O(N)
            final int[] filteredNums = IntStream.of(nums).filter(i -> i != num).toArray();
            for (List<Integer> perm: permutations(filteredNums)) {
                perm.add(num);
                result.add(perm);
            }
        }

        return result;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // inPlace operation
        permInplace(ans, nums, new ArrayList<>());

        return ans;
    }

    private void permInplace(List<List<Integer>> permutations, int[] origin, List<Integer> to) {
        if (to.size() == origin.length) {
            permutations.add(new ArrayList<>(to));
        } else {
            for (int e : origin) {
                // O(N)
                if (!to.contains(e)) {
                    // search
                    to.add(e);
                    permInplace(permutations, origin, to);

                    // backtrack
                    to.remove(to.size() - 1);
                }
            }
        }
    }
}
