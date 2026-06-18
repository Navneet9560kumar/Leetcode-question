class Solution {

    public static void swap(int []nums, int l, int r){
       while(l<r){
        int temp  = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        l++;
        r--;
       }

    }
    public void rotate(int[] nums, int k) {
        int n= nums.length;
        k = k %n;
        swap(nums, 0,n-1);
        swap(nums, 0, k-1);
        swap(nums, k, n-1);
    }
}