package others;

import java.util.stream.IntStream;

public class Test {
    public void func1(Integer a) {
        a = 2;
    }

    public static boolean isEven(int x) {
        System.out.println("map: " + x);
        return x % 2 == 0;
    }

    public static int addOne(int x) {
        System.out.println("filter: " + x);
        return x + 1;
    }

    public static void main(String[] args) {
        int a = 11;

        System.out.println(11 / 2);
        System.out.println(11 / 3);

        int b = IntStream.range(0, 1000000)
                .filter(Test::isEven)
                .map(Test::addOne)
                .limit(3)
                .sum();

        System.out.println("result: " + b);
    }
}

final class A {
    public int a = 1;
}
