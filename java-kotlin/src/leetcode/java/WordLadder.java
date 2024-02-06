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

    /*
        wordList

        hit: hot
        hot: dot, lot
        dot: dog, lot
        dog: log, cog, dot
        lot: hot, dot, log
        log: cog, dog, lot
        cog: ...

        shortest path in graph having loop -> BFS search


        wordList.length: N <= 5000
        word length: M <= 10
        N >> M


        - check all node which is adjacent to curr word in wordList
            - check all the node in wordList O(N * M)
            - check all possible words O(26 * M) 26 means the number of lowercase letters

        All words can be queued once O(N)

        Time complexity: N * (26 * M)

     */
    public int ladderLength2024(String beginWord, String endWord, List<String> wordList) {
        Queue<Node> que = new LinkedList<>();
        HashSet<String> unvisitedWordSet = new HashSet<>(wordList);

        if (!unvisitedWordSet.contains(endWord)) {
            return 0;
        }

        que.offer(new Node(beginWord, 1));

        while (!que.isEmpty()) {
            Node curr = que.poll();

            // check All possible words
            for (int i = 0; i<curr.word.length(); i++) {
                for (char c = 'a'; c<='z'; c++) {
                    String candidate = curr.word.substring(0, i) + c + curr.word.substring(i + 1);

                    if (unvisitedWordSet.contains(candidate)) {
                        if (candidate.equals(endWord)) {
                            return curr.level + 1;
                        }

                        que.offer(new Node(candidate, curr.level + 1));
                        unvisitedWordSet.remove(candidate);
                    }
                }
            }
        }

        return 0;
    }

    record Node(String word, int level) {}

    /*
       bidirectional

       bfs search
       -> Queue
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // preprocessing
        HashSet<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        final Map<String, List<String>> graph = buildGraph(wordSet);

        final Set<String> visited = new HashSet<>();
        final Queue<Node> stk = new LinkedList<>();
        stk.add(new Node(beginWord, 1));

        while (!stk.isEmpty()) {
            final Node curr = stk.poll();
            visited.add(curr.word);

            for (String cand : graph.getOrDefault(curr.word, Collections.emptyList())) {
                if (cand.equals(endWord)) return curr.level + 1;
                else if (!visited.contains(cand)) stk.add(new Node(cand, curr.level + 1));
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
