class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        int[]ans = new int[n];

        int even =0;
        int odd =1;
        for(int num : nums){
            if(num%2==0){
                ans[even] = num;
                even+=2;

            }else{
                ans[odd] = num;
                odd += 2;
            }
        }
        return ans;
    }
}