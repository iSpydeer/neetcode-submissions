class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        if (obstacleGrid[R - 1][C - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[] prevRow = new int[C + 1];
        prevRow[C - 1] = 1;

        for (int i = R - 1; i >= 0; i--) {
            int[] curRow = new int[C + 1];
            for (int j = C - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] != 1) {
                    curRow[j] = curRow[j + 1] + prevRow[j];
                }
            }
            prevRow = curRow;
        }

        return prevRow[0];
    }
}