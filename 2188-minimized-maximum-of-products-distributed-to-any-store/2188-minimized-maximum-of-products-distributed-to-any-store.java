class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
          int low = 1, high = Integer.MAX_VALUE;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canDistribute(quantities, n, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canDistribute(int[] quantities, int stores, int maxProducts) {
        int neededStores = 0;
        for (int quantity : quantities) {
            neededStores += (quantity + maxProducts - 1) / maxProducts;
        }
        return neededStores <= stores;
    }
}





