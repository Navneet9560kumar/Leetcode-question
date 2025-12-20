class Solution {
    public int minDeletionSize(String[] strs) {

        int rows = strs.length;
        int cols = strs[0].length();
        int count = 0;

        for (int j = 0; j < cols; j++) {          // column-wise
            for (int i = 0; i < rows - 1; i++) {  // row comparison
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    count++;
                    break; // move to next column
                }
            }
        }
        return count;
    }
}
