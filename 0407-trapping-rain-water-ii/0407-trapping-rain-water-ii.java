class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m=heightMap.length;
        int n=heightMap[0].length;
        int[][] directions={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> boundryCells=new PriorityQueue<>((a, b)->a[0]-b[0]);
        boolean[][] visited=new boolean[m][n];

        for(int i=0;i<m;i++)
        {
            boundryCells.offer(new int[]{heightMap[i][0], i, 0});
            visited[i][0]=true;
            boundryCells.offer(new int[]{heightMap[i][n-1], i, n-1});
            visited[i][n-1]=true;
        }

        for(int j=0;j<n;j++)
        {
            boundryCells.offer(new int[]{heightMap[0][j], 0, j});
            visited[0][j]=true;
            boundryCells.offer(new int[]{heightMap[m-1][j], m-1, j});
            visited[m-1][j]=true;
        }

        int trappedWater=0;
        while(!boundryCells.isEmpty())
        {
            int[] curr=boundryCells.poll();
            int height=curr[0];
            int i=curr[1];
            int j=curr[2];
            for(int[] dir:directions)
            {
                int newRow=i+dir[0];
                int newCol=j+dir[1];
                
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && !visited[newRow][newCol])
                {
                    trappedWater+=Math.max(height-heightMap[newRow][newCol], 0);
                    boundryCells.offer(new int[]{Math.max(height, heightMap[newRow][newCol]), newRow, newCol});
                    visited[newRow][newCol]=true;
                }
            }
        }
        return trappedWater;
    }
}