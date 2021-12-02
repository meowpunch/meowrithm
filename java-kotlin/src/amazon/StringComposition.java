package amazon;

import java.util.*;
import java.util.stream.Collectors;

public class StringComposition {

    public static void main(String[] args) {

        System.out.println(
                new StringComposition().process(
                        List.of("rockstar", "rock", "star", "rocks", "tar", "stars", "rockstars", "in", "heaven", "starinheaven")
                )
        );
    }

    /*
        input
        ["rockstar", "rock", "star", "rocks", "tar", "stars", "rockstars", "in", "heaven", "starinheaven"]

        output(print)
        "rockstar" -> "rock" + "star"
        "rockstar" -> "rocks" + "tar"
        ...
        "starinheaven" -> "star" + "in" + "heaven"


        loop
            targetWord - "rockstar"
            HashMap store occurrence of words other than targetWord

            loop excluding targetWord
                word - "star"
                check if building targetWord with the word and other words already occurred in hashMap (e.g. "rock")

     */
    public Map<String, List<List<String>>> process(List<String> input) {
        return optimized(input);
//        return bruteforce(input);
    }

    /*
        ["rockstar", "rock", "star", "rocks", "tar", "stars", "rockstars", "in", "heaven", "starinheaven"]

        larger word cannot build smaller one.
        in, tar, rock, star, rocks, stars, heaven, rockstar, starinheaven


     */
    private Map<String, List<List<String>>> optimized(List<String> input) {
        List<String> sorted = input.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        final Map<String, List<List<String>>> m = new HashMap<>();

        for (int i = 0; i < sorted.size(); i++) {
            final List<List<String>> combs = new ArrayList<>();
            final String s = sorted.get(i);
            findComposition(s, sorted.subList(0, i), new Stack<>(), combs);
            if (!combs.isEmpty()) m.put(s, combs);
        }

        return m;
    }

    /*
        check all possible candidates
     */
    private Map<String, List<List<String>>> bruteforce(List<String> input) {
        final Map<String, List<List<String>>> m = new HashMap<>();
        for (String s : input) {
            final List<List<String>> combinations = new ArrayList<>();
            findComposition(s, input.stream().filter(x -> !x.equals(s)).collect(Collectors.toList()), new Stack<>(), combinations);
            if (!combinations.isEmpty()) m.put(s, combinations);
        }
        return m;
    }


    /*
        "rockstar", {"rock", "star", "rocks", "tar", "stars", "rockstars", "in", "heaven", "starinheaven"}
        [
            {rock, star}
            {rocks, tar}
        ]

        back tracking
     */
    private void findComposition(String s, List<String> wordDict, Stack<String> combination, List<List<String>> acc) {
        if (s.length() == 0) {
            acc.add(List.copyOf(combination));
            return;
        }

        for (String prefix : wordDict) {
            if (s.startsWith(prefix)) {
                combination.push(prefix);
                findComposition(s.substring(prefix.length()), wordDict, combination, acc);
                // back tracking
                combination.pop();
            }
        }
    }


}
