package Codility;

public class TieRopes {
    /**
     *  Greedy Algorithm
     */
    public int solution(int K, int[] A) {
        int count = 0;
        int currentLength = 0;

        for (int rope: A) {
            currentLength += rope;
            if (currentLength >= K) {
                count += 1;
                currentLength = 0;
            }
        }

        return count;
    }
}
