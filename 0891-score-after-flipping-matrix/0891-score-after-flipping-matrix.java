class Solution {
    public int matrixScore(int[][] arr) {
       int m = arr.length;
    int n = arr[0].length; // Number of columns in the first row
    
    // Ensure all rows have the same number of columns
    for (int i = 1; i < m; i++) {
        if (arr[i].length != n) {
            throw new IllegalArgumentException("All rows must have the same number of columns");
        }
    }

    // The rest of your code remains the same
    // Step 1: Make sure every row starts with a 1
    for (int i = 0; i < m; i++) {
        if (arr[i][0] == 0) { // Flip the row
            for (int j = 0; j < n; j++) {
                arr[i][j] = arr[i][j] == 0 ? 1 : 0;
            }
        }
    }

    // Step 2: Flip columns where the number of 0s is greater than the number of 1s
    for (int j = 1; j < n; j++) {
        int noOfZero = 0, noOfOnes = 0;
        for (int i = 0; i < m; i++) {
            if (arr[i][j] == 0) noOfZero++;
            else noOfOnes++;
        }
        if (noOfZero > noOfOnes) {
            for (int i = 0; i < m; i++) {
                arr[i][j] = arr[i][j] == 0 ? 1 : 0;
            }
        }
    }

    // Step 3: Calculate the score
    int store = 0;
    int X = 1;
    for (int j = n - 1; j >= 0; j--) {
        for (int i = 0; i < m; i++) {
            store += (arr[i][j] * X); 
        }
        X *= 2;
    }
    return store;
}
}