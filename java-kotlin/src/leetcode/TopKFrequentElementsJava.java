package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TopKFrequentElementsJava {
    public int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums).boxed()
                // map i to # of occurrence of i
                .collect(Collectors.groupingBy(i -> i, Collectors.counting())).entrySet().stream()
                // sort and take k
                .sorted((l, r) -> r.getValue().intValue() - l.getValue().intValue()).limit(k)
                .map(i -> i.getValue().intValue()).mapToInt(Integer::intValue).toArray();
    }
}
