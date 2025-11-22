class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;

        for (int num : nums) {
            int r = num % 3;

            if (r == 1) operations += 1;  // subtract 1
            else if (r == 2) operations += 1;  // add 1
            // if r == 0 → already divisible
        }

        return operations;
    }
}