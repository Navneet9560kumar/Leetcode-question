class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        if(compare(mat, target))return true;
        int count = 3;
        while(count > 0){
            mat = rotate(mat);
            if(compare(mat, target))return true;
            count--;
        }
        return false;
    }

    private boolean compare(int[][] mat, int[][] target){
        int n = mat.length;
        for(int i=0;i<n;i++)for(int j=0;j<n;j++)if(mat[i][j]!=target[i][j])return false;
        return true;
    }

    private int[][]rotate(int[][]mat){
        int n = mat.length;
        int[][]res = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                res[n-1-j][i] = mat[i][j];
            }
        }

        return res;
    }
}