package company.n26;

import java.util.Arrays;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/*
    [1, 2, 2] -> 1
    [2, 4, 4] -> 2
*/
class Second {
  // O(N),O(1) but iterate once

  // N * x - (a1 + a2 + a3+ ... an)
  public int solution(int[] A) {
    final int[] count = new int[] {0, 0, 0, 0};
    int sum = 0;

    for (int a : A) {
      sum += a;
      count[a - 1] += 1;
    }

    int avgFloor = sum / A.length;
    int avgCeil = (sum + A.length - 1) / A.length;

    int stepsFloor = 0, stepsCeil = 0;
    for (int i = 0; i < 4; i++) {
      stepsFloor += Math.abs(avgFloor - (i + 1)) * count[i];
      stepsCeil += Math.abs(avgCeil - (i + 1)) * count[i];
    }

    return Math.min(stepsFloor, stepsCeil);
  }

  // O(N),O(1) but iterate once
  public int solutionOptimized(int[] A) {
    final int[] count = new int[] {0, 0, 0, 0};

    for (int a : A) {
      count[a - 1] += 1;
    }

    int total = A.length;
    int minSteps = Integer.MAX_VALUE;

    for (int target = 1; target <= 4; target++) {
      int steps = 0;
      for (int i = 0; i < 4; i++) {
        if (i + 1 != target) {
          steps += count[i] * Math.abs(i + 1 - target);
        }
      }
      minSteps = Math.min(minSteps, steps);
    }

    return minSteps;
  }

  // O(N),O(1) but iterate twice
  public int solutionOne(int[] A) {
    return Arrays.stream(A)
        .map(i -> Math.abs(i - Math.round((float) Arrays.stream(A).sum() / A.length)))
        .sum();
  }

  public static void main(String[] args){
  }
}
