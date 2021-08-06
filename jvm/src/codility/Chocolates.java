package codility;

public class Chocolates {
    /**
     *  The least common multiple - LCM
     *  LCM / M
     *  e.g. N = 10, M = 4
     *       LCM = 20 so, LCM / M = 5
     *  LCM = N * M / GCD
     *  LCM / M = N / GCD
     *
     */
    public int solution(int N, int M) {
        final int GCD = gcd(N, M);
        return N / GCD;
    }

    private int gcd(int x, int y) {
        if (x % y == 0) return y;

        return gcd(y, x % y);
    }
}
