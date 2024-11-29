class Solution {
   public int minimumTime(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        if (Math.min(grid[0][1], grid[1][0]) > 1) 
            return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});

        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int x = current[1];
            int y = current[2];

            if (x == row - 1 && y == col - 1) 
                return time;

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < row && newY >= 0 && newY < col && !visited[newX][newY]) {
                    int waitingTime = 0;
                    int diff = Math.abs(grid[newX][newY] - time);

                    if ((diff & 1) == 0) 
                        waitingTime = 1;

                    int newTime = Math.max(grid[newX][newY] + waitingTime, time + 1);
                    pq.add(new int[]{newTime, newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1;
    }
}