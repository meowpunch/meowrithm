package Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {

    /*
     * BFS starting from each lands.
     */
    public int maxDistance(int[][] grid) {
        final int n = grid.length;
        final boolean[][] visited = new boolean[n][n];
        final Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = new int[][]{
                new int[]{1, 0},
                new int[]{0, 1},
                new int[]{-1, 0},
                new int[]{0, -1}
        };
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            final int[] element = queue.poll();
            final int i = element[0];
            final int j = element[1];
            final int curLevel = element[2];

            if (curLevel > maxLevel) maxLevel = curLevel;

            for (int[] direction : directions) {
                final int nextI = i + direction[0];
                final int nextJ = j + direction[1];
                final int nextLevel = curLevel + 1;

                if (n > nextI && nextI >= 0 && n > nextJ && nextJ >= 0 && !visited[nextI][nextJ]) {
                    queue.offer(new int[]{nextI, nextJ, nextLevel});
                    visited[nextI][nextJ] = true;
                }
            }
        }

        return maxLevel > 0? maxLevel: -1;
    }
}
