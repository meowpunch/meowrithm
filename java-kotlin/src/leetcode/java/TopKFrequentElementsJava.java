package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElementsJava {
  public static int[] topKFrequent(int[] nums, int k) {
    return topKFrequentWithBucket(nums, k);
  }

  /*
     Time O(NlogN)
     Space O(1)
  */
  private int[] topKFrequentNaive(int[] nums, int k) {
    return Arrays.stream(nums)
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet()
        .stream()
        .sorted((e1, e2) -> e2.getValue().intValue() - e1.getValue().intValue())
        .limit(k)
        .mapToInt(Entry::getKey)
        .toArray();
  }

  /*
     [1,1,1,2,2,3] -> {1: 3, 2: 2, 3: 1}

     N: 6

     [x, 3, 2, 1, x, x]


  */
  private static int[] topKFrequentWithBucket(int[] nums, int k) {
    final List<Set<Integer>> bucket = new ArrayList<>();
    while (bucket.size() < nums.length + 1) bucket.add(new HashSet<>());

    final Map<Integer, Long> countByElements =
        Arrays.stream(nums)
            .boxed()
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    countByElements.forEach((key, value) -> bucket.get(value.intValue()).add(key));

    final List<Integer> result = new ArrayList<>(k);
    int bucketIndex = nums.length;
    while (result.size() < k) {
      while (bucket.get(bucketIndex).isEmpty()) {
        bucketIndex--;
      }

      result.addAll(bucket.get(bucketIndex));
      bucketIndex--;
    }

    return result.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(topKFrequent(new int[] {1, 1, 1, 2, 2, 3}, 2)));
    System.out.println(Arrays.toString(topKFrequent(new int[] {1, 2}, 2)));
    System.out.println(Arrays.toString(topKFrequent(new int[] {1}, 1)));
  }
}
