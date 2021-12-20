package company.amazon;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class FindMaze {

    /*
     *  Assumption
     *  - Starting point should be on top of rows.
     *  - Ending point should be on bottom of rows.
     *
     *  Algorithm - BFS
     *  - init queue for BFS (First In First Out)
     *      - storing point {x, y}
     *  - init 2D array representing whether the node is visited or not visited
     *
     */
    public static boolean solution(List<String> maze) {
        final int N = maze.size();
        final int M = maze.get(0).length();
        final BiPredicate<Integer, Integer> isValidPoint = (Integer x, Integer y)
                -> 0 <= x && x < N && 0 <= y && y < M;


        final Queue<int[]> que = new LinkedList<>();
        final boolean[][] isVisited = new boolean[N][M];

        // find starting point.
        for (int i = 0; i < M; i++) {
            if (maze.get(0).charAt(i) == '.') que.add(new int[]{0, i});
        }

        // search
        final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!que.isEmpty()) {
            // visit
            final int[] currNode = que.poll();
            isVisited[currNode[0]][currNode[1]] = true;
//            System.out.println(Arrays.toString(currNode));

            for (int[] dir : dirs) {
                final int nextX = currNode[0] + dir[0];
                final int nextY = currNode[1] + dir[1];

                // is Valid point && not Visited && char should be '.'
                if (isValidPoint.test(nextX, nextY)
                        && !isVisited[nextX][nextY]
                        && maze.get(nextX).charAt(nextY) == '.') {

                    // if exit point, return true
                    if (nextX == N - 1) return true;
                    que.add(new int[]{nextX, nextY});
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Stream.of(
                        Arrays.asList(
                                "###.######",
                                "##.......#",
                                "#####.#.##",
                                "#.....#..#",
                                "#.######.#",
                                "########.#"
                        ),
                        Arrays.asList(
                                "###.######",
                                "##.......#",
                                "#####.#.##",
                                "#.....#..#",
                                "#.######.#",
                                "##########"
                        ))
                .forEach(maze -> System.out.println(solution(maze)));

    }
}


