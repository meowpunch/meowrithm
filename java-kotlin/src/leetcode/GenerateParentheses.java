package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }


    private void backtrack(List<String> set, StringBuilder sb, int op, int cp, int n) {
        // base case
        if (sb.length() == n * 2) {
            set.add(sb.toString());
        } else {
            if (op < n) {
                backtrack(set, sb.append("("), op + 1, cp, n);
                sb.deleteCharAt(sb.length() - 1);
            }

            if (op > cp) {
                backtrack(set, sb.append(")"), op + 1, cp, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
