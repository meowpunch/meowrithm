package codility;

public class GenomicRangeQuery {
    public int[] solution(String S, int[] P, int[] Q) {
        final int N = S.length();
        // String -> prefix impact factors sum
        int[][] occurrence = new int[N][4];
        for (int i = 0; i < N; i++) {
            final int nucleotideImpact = nucleotideToImpact(S.charAt(i));
            occurrence[i][nucleotideImpact - 1] = 1;

            // accumulate
            if (i > 0)
                for (int j = 0; j < 4; j++)
                    occurrence[i][j] += occurrence[i - 1][j];
        }

        final int M = P.length;
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            final int p = P[i];
            final int q = Q[i];
            for (int j = 0; j < 4; j++) {
                int sub = (p - 1) >= 0? occurrence[p - 1][j]: 0;
                int diff = occurrence[q][j] - sub;
                if (diff > 0) {
                    result[i] = j + 1;
                    break;
                }
            }
        }
        return result;
    }

    private int nucleotideToImpact(char nucleotide) {
        switch(nucleotide) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                throw new IllegalArgumentException("Nucleotide must be 'A' or 'C' or 'G' or 'T'");
        }
    }
}
