class Solution {
    public void rotate(int[][] arr) {
        int n = arr.length;

        //Transpose 
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){

                int temp = arr[i][j];
                arr[i][j] =  arr[j][i];
                arr[j][i] = temp;
            }
        }
        for(int i=0;i<n;i++){
            int left= 0;
            int right =n-1;


            while(left<right){
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] =temp;

                left++;
                right--;
            }
        }
    }
}