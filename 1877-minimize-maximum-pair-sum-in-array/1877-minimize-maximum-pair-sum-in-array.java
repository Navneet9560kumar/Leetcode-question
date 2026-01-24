class Solution {

    public int minPairSum(int[] arr) {
      Arrays.sort(arr);

        int left = 0;
        int right = arr.length - 1;

        ArrayList<Integer> pairSums = new ArrayList<>();

        while (left < right) {
            pairSums.add(arr[left] + arr[right]);
            left++;
            right--;
        }

        int max = Collections.max(pairSums);
        return max;
    }
}