class Solution {
    public boolean isPowerSquare(int n) {

          if(n==1)return true;
           int root = (int) Math.sqrt(n);
           return root*root==n;
    }

     public boolean isPowerOfFour(int n) {
         
          if(n==1)return true;
            if(n<=0 || n%2 !=0)return false;
            return ((n & (n - 1)) == 0) && isPowerSquare(n);
    }
}