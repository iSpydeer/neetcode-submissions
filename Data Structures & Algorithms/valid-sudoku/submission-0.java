class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = board.length;
        HashSet<Character>[] rowSet = new HashSet[length];
        HashSet<Character>[] colSet = new HashSet[length];
        HashSet<Character>[] squareSet = new HashSet[length];
        initSet(rowSet);
        initSet(colSet);
        initSet(squareSet);


        for (int row = 0; row < length; row++) {
            for (int col = 0; col < length; col++) {
                char val = board[row][col];
                if (val != '.') {
                    int squareIndex = (row/3)*3 + (col/3);
                    System.out.println(rowSet[0]);
                    if (
                        checkSet(rowSet[row], val) ||
                        checkSet(colSet[col], val) ||
                        checkSet(squareSet[squareIndex], val)) {
                            return false;
                        }
                }
            }
        }
        return true;
    }

    private boolean checkSet(final HashSet<Character> hset, char val) {
        return !hset.add(val);
    }

    private void initSet(final HashSet<Character>[] hset) {
        for (int i = 0; i < hset.length; i++) {
            hset[i] = new HashSet<Character>();
        }
    }
}
