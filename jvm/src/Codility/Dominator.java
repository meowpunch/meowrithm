package Codility;
import java.util.HashMap;
import java.util.Stack;

public class Dominator {

    /**
     *  DP
     *  Time, Space: O(N), O(1)
     */
    public int solution(int[] A) {
        final int N = A.length;

        int consecutiveSize = 0;
        int candidate = 0;
        for (int a: A) {
            if (consecutiveSize == 0) {
                consecutiveSize = 1;
                candidate = a;
            } else if (candidate == a) consecutiveSize += 1;
            else consecutiveSize -= 1;
        }

        int count = 0;
        int index = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == candidate) {
                count += 1;
                index = i;
            }
        }

        return count > N / 2.0? index: -1;
    }


    /**
     *  stack: Time, Space - O(N), O(N)
     */
    public int solutionStack(int[] A) {
        Stack<Integer> stack = new Stack<>();
        final int N = A.length;

        // O(N)
        for(int a: A) {
            if (!stack.isEmpty() && stack.peek() != a) stack.pop();
            else stack.push(a);
        }

        if (!stack.isEmpty()) {
            final int leader = stack.pop();

            int count = 0;
            for (int i = 0; i < N; i++) {
                if (A[i] == leader) {
                    count += 1;
                    if (count > N/2) return i;
                }
            }
        }

        return -1;
    }

    /**
     *  Brute Force: Time, Space - O(N^2), O(1)
     *  Sorting:     Time, Space - O(NlogN), O(1), Using Heap Sort, In place
     *  DP:          Time, Space - average Linear, O(N)
     *
     *  let use Dynamic Programming
     *  memoize the occurrence of elements
     *  the range of each element is too large. So, using array makes unnecessary space.
     */
    public int solutionDP(int[] A) {
        // Key, Value <- value, occurrence
        final int N = A.length;
        HashMap<Integer, Integer> mem = new HashMap<>(N);

        int maxOccurrence = 0;
        int leaderIdx = -1;
        // O(N)
        for (int i = 0; i < N; i++) {
            final int a = A[i];
            final int occurrence = mem.getOrDefault(a, 0) + 1;

            // update
            if (maxOccurrence < occurrence) {
                maxOccurrence = occurrence;
                leaderIdx = i;
            }
            mem.put(a, occurrence);
        }

        return leaderIdx;
    }
}
