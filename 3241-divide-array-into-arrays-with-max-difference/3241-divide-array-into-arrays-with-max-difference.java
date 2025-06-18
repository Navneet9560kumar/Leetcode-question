import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // Step 1: Sort the array to make groups easily
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        // Step 2: Group elements in chunks of 3
        for (int i = 0; i < nums.length; i += 3) {
            if (i + 2 >= nums.length) {
                return new int[0][0]; // Not enough elements for a group of 3
            }

            int low = nums[i];
            int mid = nums[i + 1];
            int high = nums[i + 2];

            if (high - low <= k) {
                res.add(Arrays.asList(low, mid, high));
            } else {
                return new int[0][0]; // If any group violates the condition
            }
        }

        // Step 3: Convert List<List<Integer>> to int[][]
        return convertListToArray(res);
    }

    private int[][] convertListToArray(List<List<Integer>> list) {
        int[][] arr = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = list.get(i).get(j);
            }
        }
        return arr;
    }
}
