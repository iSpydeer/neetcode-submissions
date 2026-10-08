class Solution {
    public int shortestPath(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        } else {
            return bfs(grid);
        }
    }

    private int bfs(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] visited = new int[ROWS][COLS];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[2]);
        visited[0][0] = 1;

        int length = 0;
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int pair[] = queue.poll();
                int r = pair[0];
                int c = pair[1];

                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                int[][] nbrs = {{r, c + 1}, {r + 1, c}, {r, c - 1}, {r - 1, c}};
                for (int j = 0; j < 4; j++) {
                    int nbrR = nbrs[j][0];
                    int nbrC = nbrs[j][1];

                    if (nbrR < 0 || nbrC < 0 || nbrR == ROWS || nbrC == COLS
                        || grid[nbrR][nbrC] == 1 || visited[nbrR][nbrC] == 1) {
                        continue;
                    }

                    queue.add(nbrs[j]);
                    visited[nbrR][nbrC] = 1;
                }
            }
            length++;
        }

        return -1;
    }
}
