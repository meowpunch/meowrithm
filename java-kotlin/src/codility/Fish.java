package codility;

import java.util.Stack;

public class Fish {
    /**
     *  Let the each length of A and B be N
     *
     *  if the direction of the fish is upstream, push the size of the fish to stack
     *  else, pop stack and fight
     *
     *  O(N) / O(N)
     */
    public int solution(int[] A, int[] B) {
        // init
        final int N = A.length;
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            // push down streaming fish
            if (B[i] == 1) stack.push(A[i]);
            else {
                // up streaming fish
                // fight
                while (!stack.empty() && A[i] > stack.peek()) {
                    stack.pop();
                }
                // alive
                if (stack.empty()) count += 1;
            }
        }

        // down streaming fish alive
        while (!stack.empty()) {
            count += 1;
            stack.pop();
        }

        return count;
    }
}
