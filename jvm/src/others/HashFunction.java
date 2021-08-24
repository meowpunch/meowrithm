package others;

public class HashFunction {

    static final int hash(Object key) {
        final int h = key.hashCode();
        System.out.printf("hashCode: %s (%s)\n", h, Integer.toBinaryString(h));
        System.out.printf("h >>> 16: %s (%s)\n", h >>> 16, Integer.toBinaryString(h >>> 16));
        System.out.printf("hashCode XOR h >>> 16: %s (%s)\n", h ^ (h >>> 16), Integer.toBinaryString(h ^ (h >>> 16)));

        return (key == null) ? 0 : (key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        Object a = new Object();
        System.out.println(hash(a));
    }
}
