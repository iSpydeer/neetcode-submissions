class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int marked[][] = new int[ROWS][COLS];

        int maxArea = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int area = dfs(grid, r, c, marked);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int[][] marked) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == 0 || marked[r][c] == 1) {
            return 0;
        }

        marked[r][c] = 1;
        int area = 1;

        area += dfs(grid, r + 1, c, marked);
        area += dfs(grid, r, c + 1, marked);
        area += dfs(grid, r - 1, c, marked);
        area += dfs(grid, r, c - 1, marked);
        return area;
    }
}
