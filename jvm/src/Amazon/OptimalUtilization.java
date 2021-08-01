package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * https://leetcode.com/discuss/interview-question/373202
 */
public class OptimalUtilization {

    public static void main(String[] args) {

        Stream.of(
                OptimalUtilization.optimizeMemoryUsage(
                        Arrays.asList(
                                Arrays.asList(1, 3), Arrays.asList(2, 5), Arrays.asList(3, 7), Arrays.asList(4, 10)
                        ),
                        Arrays.asList(
                                Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 4), Arrays.asList(4, 5)
                        ),
                        10
                ),
                OptimalUtilization.optimizeMemoryUsage(
                        Arrays.asList(
                                Arrays.asList(1, 3), Arrays.asList(2, 5), Arrays.asList(5, 5),
                                Arrays.asList(3, 7), Arrays.asList(4, 10)
                        ),
                        Arrays.asList(
                                Arrays.asList(1, 2), Arrays.asList(2, 3), Arrays.asList(3, 4),
                                Arrays.asList(4, 5), Arrays.asList(5, 5)
                        ),
                        10
                )
        ).forEach(System.out::println);
    }

    /**
     * @param foregroundApps [[1, 3], [2, 5], [3, 7], [4, 10]]
     * @param backgroundApps [[1, 2], [2, 3], [3, 4], [4, 5]]
     * @param deviceCapacity 10
     * @return [[2, 4], [3, 2]]
     */
    public static List<List<Integer>> optimizeMemoryUsage(
            List<List<Integer>> foregroundApps, List<List<Integer>> backgroundApps, Integer deviceCapacity
    ) {
        final Integer fSize = foregroundApps.size();
        final Integer bSize = backgroundApps.size();

        // sort
        foregroundApps.sort(Comparator.comparingInt(l -> l.get(1)));
        backgroundApps.sort(Comparator.comparingInt(l -> l.get(1)));

        // two pointers
        Integer fPointer = 0;
        Integer bPointer = bSize - 1;

        Integer tempMax = Integer.MIN_VALUE;
        final List<List<Integer>> answer = new ArrayList<>();

        // O(N + M)
        while (fPointer < fSize && bPointer >= 0) {
            final List<Integer> fApp = foregroundApps.get(fPointer);
            final List<Integer> bApp = backgroundApps.get(bPointer);

            final Integer requiredMemorySum = fApp.get(1) + bApp.get(1);

            if (requiredMemorySum > deviceCapacity) {
                bPointer--;
            } else {
                if (!requiredMemorySum.equals(tempMax)) {
                    answer.clear();
                    tempMax = requiredMemorySum;
                }

                answer.add(Arrays.asList(fApp.get(0), bApp.get(0)));

                Integer tempBPointer = bPointer;
                while (
                        tempMax.equals(fApp.get(1) + backgroundApps.get(tempBPointer - 1).get(1))
                ) {
                    answer.add(Arrays.asList(fApp.get(0), backgroundApps.get(tempBPointer - 1).get(0)));
                    tempBPointer--;
                }

                fPointer++;
            }
        }

        return answer;
    }
}
