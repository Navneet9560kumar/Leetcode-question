class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
     Arrays.sort(items, (a, b) -> a[0] - b[0]);

        int currMax = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        tm.put(0, 0);
        for (int[] item : items) {
            currMax = Math.max(currMax, item[1]);
            tm.put(item[0], currMax);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = tm.floorEntry(queries[i]).getValue();
        }
        return res;
    }
}