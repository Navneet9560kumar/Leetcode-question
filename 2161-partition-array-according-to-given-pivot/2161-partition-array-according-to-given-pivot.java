class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n =  nums.length;
         int countLess =0;
         int countEqual =0;

         for(int num: nums){
            if(num<pivot)countLess++;
            else if(num== pivot) countEqual++;

         }
         int i =0;
         int j= countLess;
         int k = countLess + countEqual;
         int [] res = new int[n];

         for(int num : nums){
            if(num <pivot){
                res[i] = num;
                i++;
            }else if(num == pivot){
                res[j] = num;
                j++;
            }else {
                res[k] = num;
                k++;
            }
         }
         return res;
    }
}