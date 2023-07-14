package leetcode.java;

import java.util.List;
import java.util.ArrayList;

public class RemoveElement {
  /*
    Input: nums = [0,1,2,2,3,0,4,2], val = 2
 */
  public int removeElement(int[] nums, int val) {
    return removeElementWithoutTempArray(nums, val);
  }

  /*
      time: O(N), space: O(1)
   */
  private int removeElementWithoutTempArray(int[] nums, int val) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[k] = nums[i];
        k++;
      }
    }

    return k;
  }

  /*
      time: O(N), space: O(N)
   */
  private int removeElementWithTempArray(int[] nums, int val) {
    final List<Integer> temp = new ArrayList<>();

    for (int v: nums) {
      if (v != val) {
        temp.add(v);
      }
    }

    final int k = temp.size();
    for (int i = 0; i < k; i++) {
      nums[i] = temp.get(i);
    }

    return k;
  }

}
