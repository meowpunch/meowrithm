package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagrams {

  public List<List<String>> groupAnagrams(String[] strs) {
    // Map<Map<Character, Integer>, List<String>> anagramListByCharToCount = new HashMap<>();

    return Arrays.stream(strs)
        .collect(Collectors.groupingBy(this::charToCount))
        .values().stream()
        .toList();
  }

  private Map<Character, Integer> charToCount(String str) {
    final Map<Character, Integer> charToCount = new HashMap<>();

    for (char c : str.toCharArray()) {
      charToCount.put(c, charToCount.getOrDefault(c, 0) + 1);
    }

    return charToCount;
  }
}
