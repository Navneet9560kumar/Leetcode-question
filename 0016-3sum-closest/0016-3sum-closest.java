class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int n= arr.length;
         Arrays.sort(arr);
         int closestSum = arr[0] + arr[1] + arr[2];

        for(int k=0;k<n;k++){
            int i=k+1;
            int j = n-1;
        while(i<j){
            int sum =  arr[k] + arr[i] +arr[j];

            if(Math.abs(target- sum)< Math.abs(target-closestSum )){
                 closestSum = sum;
            }
            if (sum ==  target){
                return sum;
            }
            if(sum<target){
                i++;
            }else{
                j--;
            }
        }

        }
        return closestSum;
    }
}

// for(k----0){
// int i =0;
// int j= n-1;

// }