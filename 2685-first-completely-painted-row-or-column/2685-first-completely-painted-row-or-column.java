class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = arr.length;
        int row = mat.length, col = mat[0].length;
        int index = 0;
        Map<String, Integer> m1 = new HashMap<>();
        int[][] pos = new int[row * col + 1][2];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pos[mat[i][j]] = new int[]{i, j};
            }
        }
        
        while (index < n) {
            int[] curr = pos[arr[index]];
            int i = curr[0];
            int j = curr[1];
            m1.put("R" + i, m1.getOrDefault("R" + i, 0) + 1);
            m1.put("C" + j, m1.getOrDefault("C" + j, 0) + 1);
            if (m1.get("R" + i) == col || m1.get("C" + j) == row) {
                return index;
            }
            index++;
        }
        
        return -1;
    }
}