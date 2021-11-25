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

    /*
                    [ ]
             [1]         [2] [3]
        [1, 2] [1, 3]
       [1,2,3] [1,3,2]
    */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perm = new ArrayList<>();
        backtrack(perm, new ArrayList<>(), nums);
        return perm;
    }

    private void backtrack(List<List<Integer>> perm, List<Integer> curr, int[] nums) {
        // base case
        if (curr.size() == nums.length) perm.add(new ArrayList<>(curr));
        else {
            for (int n : nums) {
                if (!curr.contains(n)) {
                    curr.add(n);
                    backtrack(perm, curr, nums);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }
}
