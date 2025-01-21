class Solution {
     public long gridGame(int[][] grid) {
    long row1 = 0;
 int col_len = grid[0].length;
  for(int i = 0; i < col_len; i++) {
        row1 += (long)(grid[0][i]);
}
  long mini = Long.MAX_VALUE;
    long upper_row = 0, lower_row = 0;
for(int i = 0; i < col_len; i++) {
  row1 -= (long)(grid[0][i]);
 upper_row = row1;
lower_row += i > 0 ? (long)(grid[1][i - 1]) : 0L;
  mini = Math.min(mini, Math.max(upper_row, lower_row));
  }
 return mini;
    }
}