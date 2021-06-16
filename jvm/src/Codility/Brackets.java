package Codility;

import java.util.Stack;

public class Brackets {
    public int solution(String S) {
        // init
        Stack<Character> stack = new Stack<>();

        for (char c: S.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                stack.push(c);
            } else {
                if (c == '}' && (stack.empty() || stack.pop() != '{')) return 0;
                if (c == ')' && (stack.empty() || stack.pop() != '(')) return 0;
                if (c == ']' && (stack.empty() || stack.pop() != '[')) return 0;
            }
        }

        return stack.isEmpty()? 1: 0;
    }


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
    public int solution2(String S) {
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
        String a = "1";
        String b = String.valueOf("123".charAt(0));
        String c = "1";

        System.out.printf("%s %s %s%n", System.identityHashCode(a), System.identityHashCode(b), System.identityHashCode(c));
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
    }
}
