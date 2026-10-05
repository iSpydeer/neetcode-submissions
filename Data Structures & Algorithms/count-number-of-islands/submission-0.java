class Solution {
    public int numIslands(char[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int marked[][] = new int[ROWS][COLS];

        int islands = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                islands += dfs(grid, r, c, marked);
            }
        }

        return islands;
    }

    private int dfs(char[][] grid, int r, int c, int[][] marked) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == '0' || marked[r][c] == 1) {
            return 0;
        }

        marked[r][c] = 1;
        dfs(grid, r + 1, c, marked);
        dfs(grid, r, c + 1, marked);
        dfs(grid, r - 1, c, marked);
        dfs(grid, r, c - 1, marked);
        return 1;

    }
}
