class Solution {
    public int[] sortArrayByParityII(int[] nums) {
              int[] res = new int[nums.length];
              int evenIdx =0;
              int oddIdx =1;
              for(int num: nums){
                if(num%2==0){
                    res[evenIdx]= num;
                    evenIdx +=2;
                }else{
                    res[oddIdx] = num;
                    oddIdx +=2;
                }
              }
              return res;
    }
}