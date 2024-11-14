class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
       int left = 1;
        int right = Integer.MAX_VALUE;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(quantities, n, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canDistribute(int[] quantities, int stores, int maxProductsPerStore) {
        int requiredStores = 0;
        for (int quantity : quantities) {
            requiredStores += (quantity + maxProductsPerStore - 1) / maxProductsPerStore; 
        }
        return requiredStores <= stores;
    }
}