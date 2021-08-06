package codility;// you can also use imports, for example:

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
class LongTuple implements Comparable<LongTuple> {
    final private long x;
    final private int y;

    LongTuple(long x, int y) {
        this.x = x;
        this.y = y;
    }

    int getY() {
        return this.y;
    }

    @Override
    public int compareTo(LongTuple b) {
        return this.x != b.x ? Long.compare(this.x, b.x) : Integer.compare(b.y, this.y);
    }
}

class NumberOfDiscIntersections {
    public int solution(int[] A) {
        final long N = A.length;
        List<LongTuple> logs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            final long radius = (long) A[i];
            logs.add(new LongTuple(i - radius, 1));
            logs.add(new LongTuple(i + radius, -1));
        }

        Collections.sort(logs);

        int intersected = 0;
        int count = 0;
        for (LongTuple log : logs) {
            intersected += log.getY();

            if (log.getY() > 0) {
                count += intersected - 1;
                if (count > 10000000) return -1;
            }
        }
        return count;
    }
}