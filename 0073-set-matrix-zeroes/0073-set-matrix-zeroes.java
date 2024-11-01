class Solution {
    public void setZeroes(int[][] arr) {
        int m = arr.length, n = arr[0].length;
        // int[][] helper  = new int[m][n]; helper ke jagha mai ek kaam karunga boolean ka arr banate hain for row
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n]; // corrected from boolean[] col = new boolean[m]; to boolean[] col = new boolean[n];

        // First pass to mark the rows and columns that should be set to zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // if in case aase dekha ke arr[i][j] = 0, so ham row[i] = true, or col[j] = true; is per ham marking kar rahe perticular row and col per
                if (arr[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Set the true row to 0
        for (int i = 0; i < m; i++) {
            if (row[i]) { // set ith row is arrya ke puri row ko zero set karna hai
                for (int j = 0; j < n; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        // Set the true column to 0
        for (int j = 0; j < n; j++) {
            if (col[j]) { // set ith col is arrya ke puri column ko zero set karna hai
                for (int i = 0; i < m; i++) {
                    arr[i][j] = 0;
                }
            }
        }
    }
}

// iske leye we use a hamko (om complecity cahiye per vo nahi hai ham isame ek extra 2D array use kar rahe hai jada space kharch ho raha hai)

// the optimal approach 
// 1 we make a two-step kon se aase row hai pure ke pure zero ho jaye or kon se aase column hai puri tarha se zero ho jaye
