package test;

import java.util.*;
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

//    public static <T> List<T> asList(T... ts) {
//        T[] arrayTs = ts;
//        Arrays.asList(1,2,3).add(1);
//
//        return new ArrayList<T>(ts);
//    }

    public static void testFixedList() {
        List<Integer> fixedArray = Arrays.asList(1, 2, 3);
        List<Integer> mutableArray = new ArrayList<>(fixedArray);

        // fixedArray.add(0); -> UnsupportedOperationException
        mutableArray.add(0);

        System.out.println(fixedArray.get(0));
        System.out.println(mutableArray.get(0));
    }

    private static void changeList(List<Integer> list) {
        list.add(0);
    }

    private static void testListReference() {
        List<Integer> list = new ArrayList<>();
        changeList(list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        TreeSet
        testFixedList();
        testListReference();
        int a = 11;

        System.out.println(11 / 2);
        System.out.println(11 / 3);

        int b = IntStream.range(0, 1000000)
                .filter(Test::isEven)
                .map(Test::addOne)
                .limit(3)
                .sum();

        System.out.println("result: " + b);


        Stack<Integer> stk1 = new Stack<>();
        List<Integer> al = new ArrayList<>();


    }
}

final class A {
    public int a = 1;
}

// follow ArrayList and Arrays.asList
class Cookie {
}

class Cookies {
    public static CookieList asList(Cookie... cs) {
        return new CookieList(cs);
    }

    public static class CookieList {
        private final Cookie[] a;

        CookieList(Cookie[] array) {
            a = Objects.requireNonNull(array);
        }
    }
}