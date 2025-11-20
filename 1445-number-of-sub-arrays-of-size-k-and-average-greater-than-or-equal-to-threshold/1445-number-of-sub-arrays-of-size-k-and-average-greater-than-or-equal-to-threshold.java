class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        for(int i=0;i<k;i++){
            sum += arr[i];
        }
        int count = 0;
        int left = 0;
        int right = k-1;
        if(sum >= threshold * k){
            count++;
        }
        while(right < arr.length-1){
            sum -= arr[left];
            left++;
            right++;
            sum += arr[right];
            if(sum >= threshold * k){
                count++;
            }
        }
        return count;
    }
}