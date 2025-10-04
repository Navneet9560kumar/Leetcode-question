class Solution {
    public int maxArea(int[] h) {
        int n = h.length;
        int maxA = 0;
        int l=0;
        int r=n-1;
        while(l<r){
            int a=0;
            if(h[l]<h[r]){
                a=h[l]*(r-l);
                l++;
            }
            else{
                a=h[r]*(r-l);
                r--;
            }
            maxA= Math.max(maxA,a);
        }
        return maxA;
    }
}