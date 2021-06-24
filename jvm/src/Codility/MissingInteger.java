package Codility;

public class MissingInteger {
    public int solution(int[] A) {
        boolean[] isExist = new boolean[100001];

        for (int a: A) if (1 <= a && a <= 100000) isExist[a] = true;

        for (int i = 1; i < 100001; i++) {
            if (!isExist[i]) return i;
        }

        return 100001;
    }
}
