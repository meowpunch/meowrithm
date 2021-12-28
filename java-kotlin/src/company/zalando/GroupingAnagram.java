package company.zalando;

// you can also use imports, for example:

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingAnagram {

    public static void main(String[] args) {
        final GroupingAnagram s = new GroupingAnagram();

        System.out.println(
                "abbbbcccda".chars().mapToObj(v -> (char) v).collect(Collectors.groupingBy(v -> v))
        );

        System.out.println(
                s.rearrange(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"))
        );
        System.out.println(
                s.oneLine(Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat"))
        );

        System.out.println(s.isAnagram("nat", "tan"));
        System.out.println(s.isAnagram("eat", "bat"));
    }

    /*
        1.
        group origin values by sorted values
        {
            "aet": ["eat", "ate", "tea"],
            "abt": ["bat"]
            ...
        }

        // Suggested by Mahmoud
        {
           "eat": [],
           "nat": [],
           "bat": []
        }


        {
            "eat": ["ate","eat","tea"],
            "nat": ["tan", "nat"]
            ...
        }
     */
    public List<List<String>> rearrange(List<String> inputs) {
        final Map<String, List<String>> m = new HashMap<>();

        for (String s : inputs) {
            final String ss = sortString(s);
            if (m.getOrDefault(ss, null) == null) m.put(ss, new ArrayList<String>());
        }

        for (String s : inputs) {
            final String k = sortString(s);
            final List<String> l = m.get(k);
            l.add(s);
            m.put(k, l);
        }

        return new ArrayList<>(m.values());
    }

    public List<List<String>> oneLine(List<String> inputs) {
        return List.copyOf((inputs.stream().collect(Collectors.groupingBy(
                v -> v.chars().mapToObj(i -> (char) i).collect(Collectors.groupingBy(c -> c)))
        ).values()));
    }

    /*
        let the size of s be N

        "nat" -> {t: 1, a: 1, n: 1}
        "tan" -> {t: 1, a: 1, n: 1}

        sorting first
        compare

     */
    private boolean isAnagram(String a, String b) {
        return sortString(a).equals(sortString(b));
    }


    private String sortString(String x) {
        final char[] tempArray = x.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }
}
