class Solution {
    public int sumOfSquares(int[] nums) {
        // nnumber of elemenet ko enge or total number of element se % karnge agr sahi aayega to usko kahi safe karnge  or baad sabko * or + karke nekal denge 
        int n = nums.length;
        int sum =0;

        for(int i=1;i<=n;i++){
            if(n%i==0){
                sum  +=nums[i-1] * nums[i-1];
            }
        }
        return sum;
    }
}