package deliveryhero;

import java.util.List;

public class ClosetNumber {
    public static void main(String[] args) {
        System.out.println(new ClosetNumber().closetNumber(
                List.of(3,2,1,5,6), 4
        ));
        // returning 3 or 5?
    }

    public Integer closetNumber(List<Integer> numbers, int target) {
        int minIdx = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.size(); i++) {
            final int diff = Math.abs(target - numbers.get(i));
            if (diff < minDiff) {
                minDiff = diff;
                minIdx = i;
            }
        }

        return numbers.get(minIdx);
    }
}
