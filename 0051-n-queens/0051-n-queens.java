class Solution {
  public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();
        queen(board, 0, ans);
        return ans;
    }

    // Backtracking function
    public void queen(char[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            ans.add(makeString(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                queen(board, row + 1, ans);
                board[row][col] = '.';
            }
        }
    }

    // Check if a queen can be placed at board[row][col]
    public boolean isSafe(char[][] board, int row, int col) {
        // Check vertical
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    // Convert the board to List<String>
    public List<String> makeString(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}