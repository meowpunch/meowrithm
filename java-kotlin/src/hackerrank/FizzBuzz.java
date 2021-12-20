package hackerrank;

import java.util.stream.IntStream;

public class FizzBuzz {
    /*
     * Complete the 'fizzBuzz' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void fizzBuzz(int n) {
        // Write your code here
        IntStream.range(1, n + 1).mapToObj(
                i -> {
                    if (i % 15 == 0) return "FizzBuzz";
                    else if (i % 3 == 0) return "Fizz";
                    else if (i % 5 == 0) return "Buzz";
                    else return String.valueOf(i);
                }
        ).forEach(s -> System.out.println(s));
    }


}
