class Solution {
    public int countPaths(int[][] grid) {
        int[][] visited = new int[grid.length][grid[0].length];
        return dfs(grid, 0, 0, visited);
    }

    private int dfs(int[][] grid, int r, int c, int[][] visited) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        if (r < 0 || c < 0 || r == ROWS || c == COLS || visited[r][c] == 1 || grid[r][c] == 1) {
            return 0;
        }

        if (r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }

        visited[r][c] = 1;
        int count = 0;

        count += dfs(grid, r + 1, c, visited);
        count += dfs(grid, r, c + 1, visited);
        count += dfs(grid, r - 1, c, visited);
        count += dfs(grid, r, c - 1, visited);

        visited[r][c] = 0;
        return count;
    }
}
