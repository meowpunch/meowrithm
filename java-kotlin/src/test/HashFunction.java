package test;

import java.util.HashMap;

public class HashFunction {

    static int hash(Object key) {
        final int h = key.hashCode();
        System.out.printf("hashCode: %s (%s)\n", h, Integer.toBinaryString(h));
        // shift
        System.out.printf("h >>> 16: %s (%s)\n", h >>> 16, Integer.toBinaryString(h >>> 16));
        // xor
        System.out.printf("hashCode XOR h >>> 16: %s (%s)\n", h ^ (h >>> 16), Integer.toBinaryString(h ^ (h >>> 16)));

        return (key == null) ? 0 : (key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
//        new HashMap<>().put()
        Object a = new Object();
        System.out.println(hash(a));
        System.out.println(10 & 31);
        System.out.println(10 & 32);
        System.out.println(10 & 33);
        System.out.println(10 & 7);
        System.out.println(10 & 111);
        System.out.println(111 & 10);


    }
}
