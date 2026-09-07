class Solution {

    public static int findleftmost(int[] nums, int target, int n) {
        int l = 0, r = n - 1;
        int left_most = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                left_most = mid;
                r = mid - 1;       // aur left jao
            }
            else if (nums[mid] < target) {
                l = mid + 1;       // right jao
            }
            else {
                r = mid - 1;       // left jao
            }
        }

        return left_most;
    }


    public static int findrightmost(int[] nums, int target, int n) {
        int l = 0, r = n - 1;
        int right_most = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                right_most = mid;
                l = mid + 1;       // aur right jao
            }
            else if (nums[mid] < target) {
                l = mid + 1;       // right jao
            }
            else {
                r = mid - 1;       // left jao
            }
        }

        return right_most;
    }


    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int leftmost = findleftmost(nums, target, n);
        int rightmost = findrightmost(nums, target, n);

        return new int[]{leftmost, rightmost};
    }
}

