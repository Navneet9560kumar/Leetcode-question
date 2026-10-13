class Solution {
    public long maxAlternatingSum(int[] arr) {
        int n= arr.length;
        for(int i=0;i<n;i++){
            arr[i]=  arr[i] *arr[i];

        }
        Arrays.sort(arr);
        
        long small = Arrays.stream(arr, 0, n / 2).asLongStream().sum();
        long large = Arrays.stream(arr, n / 2, n).asLongStream().sum();


          return large - small;
    }
}