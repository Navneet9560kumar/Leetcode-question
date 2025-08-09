class Solution {
    public int removeDuplicates(int[] nums) {
        int n= nums.length;
        int i=0,j=1;
        while(j<n){
            if(nums[i] !=nums[j]){ // got a uniqe element
            i++;
            nums[i]=nums[j];

            }
            j++;
        }
        return i+1;
    }
}