class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int ogColor = image[sr][sc];
        if (ogColor != color) {
            dfs(image, sr, sc, color, ogColor);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int color, int ogColor) {
        int ROWS = image.length;
        int COLS = image[0].length;
        
        if (r < 0 || c < 0 || r == ROWS || c == COLS || image[r][c] != ogColor) {
            return;
        }

        image[r][c] = color;
        dfs(image, r + 1, c, color, ogColor);
        dfs(image, r, c + 1, color, ogColor);
        dfs(image, r - 1, c, color, ogColor);
        dfs(image, r, c - 1, color, ogColor);

        return;
    }
}