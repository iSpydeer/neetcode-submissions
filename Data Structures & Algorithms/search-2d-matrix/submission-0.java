class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int L = 0;
        int R = matrix.length-1;

        int n = matrix[0].length;
        if (n == 0) { 
            return false;
        }

        while (L <= R) {
            int M = (L+R)/2;
            if (target < matrix[M][0]) {
                R = M - 1;
            } else if(target > matrix[M][n-1]) {
                L = M + 1;
            } else {
                return searchMatrix(matrix[M], target);
            }
        }
        return false;
    }

    private boolean searchMatrix(int[] matrix, int target) {
        int L = 0;
        int R = matrix.length-1;

        while (L <= R) {
            int M = (L+R)/2;
            if (target < matrix[M]) {
                R = M - 1;
            } else if(target > matrix[M]) {
                L = M + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
