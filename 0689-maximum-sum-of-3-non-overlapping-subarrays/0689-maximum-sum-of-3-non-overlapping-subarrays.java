class Solution {
   public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int current_sum=0;
        int len=nums.length;
        int[] Ksum=new int[len-k+1];
        for(int i=0;i<k;i++)
        {
        current_sum+=nums[i];   // sum of first k elements
        }
        //use sliding window to find the sum of the subarrays of size k and store it to KSum array
        Ksum[0]=current_sum;
        for(int i=1;i<(len-k+1);i++)
        {
        Ksum[i]=current_sum+=nums[i+k-1]-nums[i-1];
        // Ksum[i]=current_sum;
        }
        // find the best Ksum to the left of a particular index  and store it's index in bestLeft array

       int best=Ksum[0];
       int bestIndex=0;
       int[] bestLeft=new int[len-k+1];
       for(int i=0;i<(len-k+1);i++)
       {
        if(Ksum[i]>best)
        {
        best=Ksum[i];
        bestIndex=i;  
        }
        bestLeft[i]=bestIndex;
       }
        // find the best Ksum to the right of a particular index  and store it's index in bestRight array
        best=Ksum[len-k];
        bestIndex=len-k;
        int[] bestRight=new int[len-k+1];
       for(int i=(len-k);i>=0;i--)
       {
        if(Ksum[i]>=best)
        {
        best=Ksum[i];
        bestIndex=i;
        }
        bestRight[i]=bestIndex;
       }
       // find the best middle by finding total at each points of Ksum array with 3 index - left , right and middle .     where the sum is max fix the middle pointer
 int maxSum=0;
 int indexLeft=0;
 int indexMid=0;
 int indexRight=0;
    for(int i=k;i<(len-2*k+1);i++)   // start from K go till length - k  ie  length= len-k+1  ,  length - k = len-2*k+1
    {
   int total=Ksum[bestLeft[i-k]] + Ksum[i] + Ksum[bestRight[i+k]] ;   
   // to avoid overlapping we find i-k to take as the index of first subarray ie left . i+k to take as last subarray ie right . i as    middle . Using these we get the index that has the best sum from bestLeft and bestRight array respectively then add it with value at middle index to get total.
   if(total>maxSum)
  {
    maxSum=total;
    indexLeft=bestLeft[i-k];
    indexMid=i;
    indexRight=bestRight[i+k];
  }
    }
    return new int[]{indexLeft,indexMid,indexRight};
    }
}