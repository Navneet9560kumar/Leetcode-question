class Solution {
    public int removeDuplicates(int[] nums) {
//         int count=1;
//         for(int i=1;i<nums.length;i++){
//         if(nums[i] != nums[i-1]){
//         nums[count]=nums[i];
//         count++;

//     }
// }
// return count;

if (nums.length == 0) return 0;

        int i = 0; // slow pointer
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // Overwrite duplicate with unique
            }
        }

        return i + 1; 
    }
}