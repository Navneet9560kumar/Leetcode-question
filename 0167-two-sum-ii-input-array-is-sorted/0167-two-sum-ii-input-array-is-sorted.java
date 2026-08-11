class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int i=0, j=n-1;
        while(i<j){
            if(arr[i]+arr[j]>target){
                 j--;
            }else if(arr[i]+arr[j]<target){
                i++;
            }else  return new int[]{i + 1, j + 1};
        }
       
        return new int[]{-1, -1};
    }
}