class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            if (!isValidSubgrid(board, row, 0, row, 8)) {
                return false;
            }
        }

        for (int col = 0; col < 9; col++) {
            if (!isValidSubgrid(board, 0, col, 8, col)) {
                return false;
            }
        }

        // Check each 3x3 subgrid
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidSubgrid(board, i, j, i + 2, j + 2)) {
                    return false;
                }
            }
        }

        return true;
    }
    private boolean isValidSubgrid(char[][] board, int startX, int startY, int endX, int endY) {
        boolean[] seen = new boolean[10]; // track the digits 1-9

        for (int i = startX; i <= endX; i++) {
            for (int j = startY; j <= endY; j++) {
                char currentChar = board[i][j];
                if (currentChar != '.') {
                    int digit = currentChar - '0';

                    if (seen[digit]) {
                        return false;
                    }

                    seen[digit] = true;
                }
            }
        }

        return true;
    }

}