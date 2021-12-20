package company.tomtom;

public class Debug {

    public static void main(String[] args) {
        /*
            1
            11 - 1
            1001001 - 3

         */
        System.out.println(new Debug().solution(1));
        System.out.println(new Debug().solution(3));
        System.out.println(new Debug().solution(64 + 8 + 1));
    }

    int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p <= l / 2; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

}
