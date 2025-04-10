class Solution {
    public int largestIsland(int[][] grid) {
        //creating the components by union by size
        int rows = grid.length;
        int cols = grid[0].length;
        DisjointSet ds = new DisjointSet(rows * cols -1);

        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j] == 1)
                {
                    for(int[] direction : dir)
                    {
                        int nr = i+direction[0];
                        int nc = j + direction[1];
                        if(isValid((grid),nr,nc) && grid[nr][nc] == 1)
                        {
                            ds.unionBySize(i * cols + j,nr*cols + nc);
                        }
                    }
                }
            }
        }

        int max = 0;
        boolean hasZero = false;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(grid[i][j] == 0)
                {
                    hasZero = true;
                    HashSet<Integer> set = new HashSet<>();
                    int size = 1;
                    for(int[] direction : dir)
                    {
                        int nr = i+direction[0];
                        int nc = j + direction[1];
                        if(isValid((grid),nr,nc) && grid[nr][nc] == 1)
                        {
                            int parent = ds.findUPar(nr * cols+nc);
                            if(!set.contains(parent))
                            {
                                set.add(parent);
                                size+= ds.size.get(parent);
                            }
                        }
                    }
                    max= Math.max(size,max);
                }
            }
        }
        ds = null;
        return hasZero? max  : rows*cols;
    }
    static int dir[][] = {{1,0},{-1,0},{0,-1},{0,1}};

    boolean isValid(int[][] grid,int r,int c)
    {
        int rows = grid.length;
        int cols = grid[0].length;

        if(r>=0 && r < rows && c <cols && c>=0 )
        {
            return true;
        }
        return false;
    }
}
public class DisjointSet {
    // List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            // rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionBySize(int u,int v)
    {
        int par_u = findUPar(u);
        int par_v= findUPar(v);
        if(par_u == par_v)
        {
            return;
        }
        else if(size.get(par_u) < size.get(par_v))
        {
            parent.set(par_u,par_v);
            size.set(par_v,size.get(par_v) + size.get(par_u));
        }
        else {
            parent.set(par_v,par_u);
            size.set(par_u,size.get(par_u) + size.get(par_v));
        }
    }

    // public void unionByRank(int u,int v)
    // {
    //     int ult_u = findUPar(u);
    //     int ult_v = findUPar(v);
    //     if(ult_u == ult_v) return;
    //     if(rank.get(ult_u) < rank.get(ult_v))
    //     {
    //         parent.set(ult_u,ult_v);
    //     }
    //     else if(rank.get(ult_v) < rank.get(ult_u))
    //     {
    //         parent.set(ult_v,ult_u);
    //     }
    //     else {
    //         parent.set(ult_v,ult_u);
    //         rank.set(ult_u, rank.get(ult_u) + 1);
    //     }
    // }
}