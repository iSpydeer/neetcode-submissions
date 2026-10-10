class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] visited = new int[ROWS][COLS];
        int freshFruits = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                    visited[i][j] = 1;
                }

                if (grid[i][j] == 1) {
                    freshFruits++;
                }
            }
        }

        if (freshFruits == 0) {
            return 0;
        }

        if (queue.isEmpty()) {
            return -1;
        }

        int length = 0;

        while (!queue.isEmpty() && freshFruits > 0) {
            length++;
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                int[][] nbrs = {{r, c + 1}, {r + 1, c}, {r, c - 1}, {r - 1, c}};

                for (int j = 0; j < 4; j++) {
                    int newR = nbrs[j][0];
                    int newC = nbrs[j][1];

                    if (newR < 0 || newC < 0 || newR == ROWS || newC == COLS
                        || grid[newR][newC] == 0 || visited[newR][newC] == 1) {
                        continue;
                    };

                    grid[newR][newC] = 2;
                    visited[newR][newC] = 1;
                    queue.add(nbrs[j]);
                    freshFruits--;
                }
            }
        }

        return freshFruits != 0 ? -1 : length;
    }
}
