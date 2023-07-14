package leetcode.java;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 0, nums);
        return ans;
    }

    /*
        nums : [1,2,3]
                         []
        1       []              [1]
        2   []      [2]       ...
        3 []  [3] [2] [2,3]             [1,2,3]

    */
    private void backtrack(List<List<Integer>> ans, List<Integer> curr, int i, int[] nums) {
        if (i > nums.length - 1) {
            ans.add(new ArrayList<>(curr));
        } else {
            // not add nums[i]
            backtrack(ans, curr, i + 1, nums);

            // add nums[i]
            curr.add(nums[i]);
            backtrack(ans, curr, i + 1, nums);
            curr.remove(curr.size() - 1);
        }
    }

}
