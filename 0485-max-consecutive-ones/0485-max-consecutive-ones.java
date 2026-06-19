class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int max = 0;
int i = 0;

for (int j = 0; j < arr.length; j++) {
    if (arr[j] == 0) {
        i = j + 1;
    }

    max = Math.max(max, j - i + 1);
}
return max;
    }
}