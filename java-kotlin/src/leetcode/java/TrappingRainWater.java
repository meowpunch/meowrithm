package leetcode.java;

public class TrappingRainWater {

  /*
    height = [0,1,0,2,1,0,1,3,2,1,2,1]

    leftMax =  [0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3]
    rightMax = [3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1]
 */
  public int trap(int[] height) {
    final var N = height.length;
    var leftMax = new int[N];
    var rightMax = new int[N];

    leftMax[0] = height[0];
    for (var l = 1; l < N; l++) {
      leftMax[l] = Math.max(height[l], leftMax[l - 1]);
    }

    rightMax[N - 1] = height[N - 1];
    for (var r = N - 2; r >= 0; r--) {
      rightMax[r] = Math.max(height[r], rightMax[r + 1]);
    }

    int trappedWater = 0;
    for (var i = 0; i < N; i++) {
      var min = Math.min(leftMax[i], rightMax[i]);
      if (height[i] < min) {
        trappedWater += min - height[i];
      }
    }

    return trappedWater;
  }
}
