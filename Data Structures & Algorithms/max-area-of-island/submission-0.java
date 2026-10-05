class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int marked[][] = new int[ROWS][COLS];

        int maxArea = 0;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                int area = dfs(grid, r, c, marked, 0);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int[][] marked, int area) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == 0 || marked[r][c] == 1) {
            return area;
        }

        marked[r][c] = 1;
        area++;

        area = dfs(grid, r + 1, c, marked, area);
        area = dfs(grid, r, c + 1, marked, area);
        area = dfs(grid, r - 1, c, marked, area);
        area = dfs(grid, r, c - 1, marked, area);
        return area;
    }
}
