package Codility;

import java.util.Stack;

public class Brackets {
    public String matchString(String S) {
        // System.out.println(S);
        switch(S) {
            case "(":
                return ")";
            case "{":
                return "}";
            case "[":
                return "]";
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * Time, Space - O(N), O(N)
     */
    public int solution(String S) {
        // init
        final int N = S.length();

        // S is empty
        if (N == 0) return 1;

        Stack<String> stk = new Stack<>();

        // matching Brackets - O(N)
        for (int i = 0; i < N; i++) {
            String ch = String.valueOf(S.charAt(i));

            try {
                if (!stk.empty() && ch.equals(matchString(stk.peek()))) stk.pop();
                else {stk.push(ch);}
            } catch(IllegalArgumentException e) {
                return 0;
            }
        }

        if (stk.empty()) return 1;
        else return 0;
    }

    public static void main(String[] args) {
    }
}
