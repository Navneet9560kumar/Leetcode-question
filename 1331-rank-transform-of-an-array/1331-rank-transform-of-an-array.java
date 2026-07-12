class Solution {
    public int[] arrayRankTransform(int[] arr) {
       int n = arr.length;

        // Copy original array
        int[] temp = arr.clone();

        // Sort the copy
        Arrays.sort(temp);

        // Store unique element -> rank
        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int num : temp) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }

        // Build answer
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}