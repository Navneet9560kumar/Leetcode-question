class Solution {
     public static int[] runningSum(int[] arr) {
                  int n = arr.length;
                  int[] result = new int[n];
                  result[0] = arr[0];
                  for (int i = 1; i < n; i++) {
                      result[i] = result[i - 1] + arr[i];
                  }
                  return result;
    }
}