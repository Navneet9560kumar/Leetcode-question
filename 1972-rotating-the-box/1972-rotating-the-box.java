class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int n = box.length;
        int m = box[0].length;

        // Slide stones down within each row
        for (int r = 0; r < n; r++) {
            for (int c = m - 1; c >= 0; c--) {
                if (box[r][c] == '#') {
                    int col = c;
                    while (col < m - 1 && box[r][col + 1] == '.') {
                        col++;
                    }
                    if (col != c) {
                        box[r][c] = '.';
                        box[r][col] = '#';
                    }
                }
            }
        }

        // Rotate the box 90 degrees clockwise
        char[][] ans = new char[m][n];
        for (int c = 0; c < m; c++) {
            for (int r = 0; r < n; r++) {
                ans[c][n - 1 - r] = box[r][c];
            }
        }

        return ans;
    }
}