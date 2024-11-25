class Solution {
    public int mySqrt(int x) {
       
        //   return (int)(Math.sqrt(x));// ye ho jata hai per isko use nahi karege ham or to or new method se karege aaram se (Newton raphson method)
          long lo=0,hi=(long)x;
          while(lo<=hi){
            long mid = lo+(hi-lo)/2;
             if(mid*mid==(long)x) return (int)mid;
             else if(mid*mid>(long)x){
                hi=mid-1;
             }else if(mid*mid<x){
                lo= mid+1;
             }
          }
        return (int)hi;
    }
}