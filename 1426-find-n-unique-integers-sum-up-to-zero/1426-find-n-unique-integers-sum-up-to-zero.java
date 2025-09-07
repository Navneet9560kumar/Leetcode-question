class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];  // initialize result array
        int i = 0, ele = 1;
        while(i+1<n){
            arr[i] = ele;
            arr[i+1] = -ele;
            ele++;
            i+=2;
        }
        return arr;
    }
}