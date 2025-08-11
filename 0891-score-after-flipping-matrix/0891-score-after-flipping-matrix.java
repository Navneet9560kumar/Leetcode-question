class Solution {
    public int matrixScore(int[][] arr) {
        int m = arr.length,  n = arr[0].length;
        // put 1 at the 0th positios of eveery row 

        for (int i = 0; i < m; i++) {
            if(arr[i][0]==0){
                  for (int j = 0; j <n; j++) {
                       if(arr[i][j]==0) arr[i][j] =1;
                       else arr[i][j] = 0; 
                  }
            }
        }
        //filp there columms where no of (no of 0)
        for(int j=1;j<n;j++){
            int noOfZero =0, noOfOnes=0;
            for(int i=0;i<m;i++){
                  if(arr[i][j]==0)noOfZero++;
                  else noOfOnes++;
            }
            if(noOfZero>noOfOnes){
                  for(int i=0;i<m;i++){
                       if(arr[i][j]==0) arr[i][j] =1;
                       else arr[i][j] = 0; 
                  }
            }
        }
       int score = 0;
for (int i = 0; i < m; i++) {
    int rowValue = 0;
    for (int j = 0; j < n; j++) {
        rowValue = rowValue * 2 + arr[i][j];  // build binary number
    }
    score += rowValue;
}
return score;

    }

    
}