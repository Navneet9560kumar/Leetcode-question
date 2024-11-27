class Solution {

   
        public static int findDays(int[] weight, int cap) {
        int days = 1;
        int load = 0;
        int n = weight.length;
        for (int i = 0; i < n; i++) {
            if (load + weight[i] > cap) {
                days += 1;
                load = weight[i];
            } else {
                load += weight[i];
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int weight : weights) {
            high += weight;
            low = Math.max(low, weight);
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int numberOfDays = findDays(weights, mid);
            if (numberOfDays <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}