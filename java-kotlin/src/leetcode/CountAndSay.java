package leetcode;

public class CountAndSay {
    /*
        n = 1: "1"
        countAndSay(n) = count number in "countAndSay(n - 1)" and say it.
    */
    public String countAndSay(int n) {
        // base n = 1
        if (n == 1) return "1";

        return countNumberInStringAndReturnString(countAndSay(n - 1));
    }

    /*
        assume input s should consist of number.
    */
    private String countNumberInStringAndReturnString(String s) {
        final StringBuilder sb = new StringBuilder();

        char currChar = '0';
        int count = 0;
        for (char c : s.toCharArray()) {
            if (currChar != c) {
                if (currChar != '0') sb.append(count).append(currChar);
                currChar = c;
                count = 0;
            }

            count += 1;
        }

        sb.append(count).append(currChar);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4));
        char a = 0;
        System.out.println(a);
    }
}
