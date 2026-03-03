class NumMatrix {

    int[][] prefix;  // 👈 ye missing tha

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Agar hum (i,j) pe khade hain, toh: hamko   overlap  dekhna hai ok to seen aasa hai ke to us   overlap  walo ko hatane ke leye ham 
        // prefix naam new array banayege ok

        // extra row and column to avoid boundary checks
        prefix = new int[rows + 1][cols + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                prefix[i][j] = matrix[i - 1][j - 1] // current value matrix[i - 1][j - 1] 
                        + prefix[i - 1][j] // upar wala rectangle prefix[i - 1][j] 
                        + prefix[i][j - 1] // left wala rectangle  prefix[i][j - 1]
                        - prefix[i - 1][j - 1];// ab ye overlap ko hatna bhi hoga hamko to - kar keya 
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1]
                - prefix[row1][col2 + 1]
                - prefix[row2 + 1][col1]
                + prefix[row1][col1];
    }
}