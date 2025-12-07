class Solution {
    public int countOdds(int n, int m) {
         return (m - n) / 2 + ((n % 2 != 0 || m % 2 != 0) ? 1 : 0);
    }
}