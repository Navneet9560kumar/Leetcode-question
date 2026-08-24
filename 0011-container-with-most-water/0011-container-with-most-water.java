class Solution {
    public int maxArea(int[] arr) {
        ArrayList<Integer>st = new ArrayList<>();
        int n = arr.length;
        int i =0;
        int j= n-1;
        int max=0;
       while(i<j){
        int h = Math.min(arr[i], arr[j]);
        int w = j-i;
        int avg = h*w;
        max =  Math.max(max, avg);
        if(arr[i]<arr[j]){
            i++;

        }else{
            j--;
        }
        

       
       }
       return max;
       
        
    }
}