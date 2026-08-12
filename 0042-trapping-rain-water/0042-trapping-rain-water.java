class Solution {

    public static  int[]getleftMax(int[]arr, int n){
        int[]leftMax = new int[n];
        leftMax[0] = arr[0];
        for(int i=1;i<n;i++){
            leftMax[i]= Math.max(leftMax[i-1], arr[i]);
        }
        return leftMax;
    }
    public  static int[]getRightMax(int[]arr, int n){
        int[]Rightmax = new int[n];
        Rightmax[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            Rightmax[i]= Math.max(Rightmax[i+1], arr[i]);
        }
        return Rightmax;
    }
    public int trap(int[] arr) {
        int n = arr.length;
        if(n==1 || n==0){
            return 0;
        }
        int[] leftMax = getleftMax(arr,n);
        int[] rightMax = getRightMax(arr, n);

        int sum =0;
        for(int i=0;i<n;i++){
            sum +=Math.min(leftMax[i],rightMax[i]) - arr[i];
        }
         return sum;
    }
}

// is kokarne  ke leye hamne ye keya hai ke ham 
//i=min (leftmax-i,rightmax-i)-h[i];