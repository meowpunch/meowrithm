package company.n26;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Third {
  public int solution(int[] A) {
    final int N = A.length;
    if (N <= 1) {
      return 1;
    }

    int direction = 0; // 0 for flat, 1 for uphill, -1 for downhill
    int castles = 1; // Always build at the start

    for (int i = 1; i < N; i++) {
      if (A[i] > A[i - 1] && direction <= 0) {
        direction = 1;
        castles++;
      } else if (A[i] < A[i - 1] && direction >= 0) {
        direction = -1;
        castles++;
      }
    }

    return castles;
  }
}
