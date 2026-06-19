class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}



// // i = 0
// j = n - 1
// while(i < j) {
//     int sum = nums[i] + nums[j];

//     if(sum == target)
//         return new int[]{i, j};

//     else if(sum < target)
//         i++;

//     else
//         j--;
// }