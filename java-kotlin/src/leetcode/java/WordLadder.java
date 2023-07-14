package leetcode.java;

import java.util.*;
import java.util.stream.Collectors;

public class WordLadder {
    public static void main(String[] args) {
        final WordLadder wl = new WordLadder();
        System.out.println(wl.isAdjacent("abc", "acc"));
        System.out.println(wl.isAdjacent("abc", "ccc"));

        System.out.println(wl.buildGraph(Set.of("hot", "dot", "dog", "lot", "log", "cog")));

        System.out.println(wl.ladderLength("hit", "cog", new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"))));
    }

    private static class Node {String value; Integer depth; Node(String value, Integer depth) {this.value = value; this.depth = depth;}}

    /*
       bidirectional

       bfs search
       -> Queue
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // preprocessing
        HashSet wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        final Map<String, List<String>> graph = buildGraph(wordSet);

        final Set<String> visited = new HashSet<>();
        final Queue<Node> stk = new LinkedList<>();
        stk.add(new Node(beginWord, 1));

        while (!stk.isEmpty()) {
            final Node curr = stk.poll();
            visited.add(curr.value);

            for (String cand : graph.getOrDefault(curr.value, Collections.emptyList())) {
                if (cand.equals(endWord)) return curr.depth + 1;
                else if (!visited.contains(cand)) stk.add(new Node(cand, curr.depth + 1));
            }

        }

        return 0;
    }

    private Map<String, List<String>> buildGraph(Set<String> wordSet) {
        return wordSet.stream()
                .collect(Collectors.toMap(s -> s, s -> wordSet.stream().filter(x -> isAdjacent(x, s)).collect(Collectors.toList())));
    }

    private boolean isAdjacent(String a, String b) {
        if (a.length() != b.length()) return false;
        else {
            int count = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    count++;
                    if (count > 1) return false;
                }
            }
            return count == 1;
        }
    }
}
