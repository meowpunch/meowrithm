package leetcode.java;

public class RotateArray {

  public void rotate(int[] nums, int k) {
    rotateWithExtraSpace(nums, k);
    // simulateRotating(nums, k);
  }

  // time: O(N), space: O(N)
  private void rotateWithExtraSpace(int[] nums, int k) {
    k = k % nums.length;
    int[] temp = new int[nums.length];

    for (int i = 0; i < nums.length; i++) {
      temp[(i + k) % nums.length] = nums[i];
    }

    for (int i = 0; i < nums.length; i++) {
      nums[i] = temp[i];
    }
  }

  // time: O(N*k), space: O(1)
  private void simulateRotating(int[] nums, int k) {
    k = k % nums.length;

    for (int i = 0; i < k; i++) {
      rotateOneStep(nums);
    }
  }

  private void rotateOneStep(int[] nums) {
    int prev = nums[nums.length - 1];
    for (int i = 0; i < nums.length; i++) {
      int temp = nums[i];
      nums[i] = prev;
      prev = temp;
    }
  }
}
