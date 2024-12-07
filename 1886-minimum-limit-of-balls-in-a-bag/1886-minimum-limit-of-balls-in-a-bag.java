class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
       int maxInt=0;
        for(int i:nums) maxInt=Math.max(i,maxInt);
        int start=1,end=maxInt;
        while(start<end){
            int mid=(start+end)/2;
            int count=0;
            for(int a:nums){
                count+=(a-1)/mid;
            }
            if(count>maxOperations){
                start=mid+1;
            }else{
                end=mid;
            }
        }
        return start;
    }
}