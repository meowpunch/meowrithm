package leetcode.java;

public class RemoveDuplicatesFromSortedArray {
  /*
      Input: nums = [0,0,1,1,1,1,2,3,3]
   */
  public int removeDuplicates(int[] nums) {
    int k = 1;
    int count = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        count++;
        if (count > 2) {
          continue;
        }
      } else {
        count = 1;
      }

      nums[k] = nums[i];
      k++;
    }

    return k;
  }
}
