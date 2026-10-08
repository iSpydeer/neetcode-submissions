class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
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

        visited[0][0] = 1;
        queue.add(new int[2]);

        int length = 1;
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int pair[] = queue.poll();
                int r = pair[0];
                int c = pair[1];

                // System.out.println("r: " + r + ", c: " + c + ", length:" + length);

                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }

                int[][] nbrs = {{r, c + 1}, {r + 1, c + 1}, {r + 1, c}, {r + 1, c - 1}, {r, c - 1},
                    {r - 1, c - 1}, {r - 1, c}, {r - 1, c + 1}};

                for (int j = 0; j < 8; j++) {
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