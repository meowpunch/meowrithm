package company.zalando;

import java.util.Stack;

public class RemoveString {

  public String solution(String S) {
    if (S.isEmpty() || S.length() == 1) {
      return S;
    }

    Stack<Character> stk = new Stack<>();
    for (int i = 0; i<S.length(); i++) {
      if (stk.isEmpty()) {
        stk.push(S.charAt(i));
        continue;
      }
      char prevChar = stk.peek();
      char currChar = S.charAt(i);

      if (isRemovable(prevChar, currChar)) {
        stk.pop();
      } else {
        stk.push(currChar);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (char c : stk) {
      sb.append(c);
    }

    return sb.toString();
  }

  private boolean isRemovable(char prevChar, char currChar) {
    return (prevChar == 'A' && currChar == 'B')
            || (prevChar == 'B' && currChar == 'A')
            || (prevChar == 'C' && currChar == 'D')
            || (prevChar == 'D' && currChar == 'C');
  }
}
