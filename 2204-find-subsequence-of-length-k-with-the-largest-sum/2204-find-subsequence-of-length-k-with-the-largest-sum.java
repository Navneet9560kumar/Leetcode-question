class Solution {
    public int[] maxSubsequence(int[] arr, int k) {
        int[][] elements = new int[arr.length][2];
        int n = arr.length;
        for(int i=0;i<n;i++){
            elements[i][0] = arr[i];
            elements[i][1] = i; 
        }
         Arrays.sort(elements, (a, b) -> Integer.compare(b[0], a[0]));
         int[][] selected = Arrays.copyOfRange(elements, 0, k);
                Arrays.sort(selected, (a, b) -> Integer.compare(a[1], b[1]));
                 int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = selected[i][0];
        }

        return result;
    
    }
}