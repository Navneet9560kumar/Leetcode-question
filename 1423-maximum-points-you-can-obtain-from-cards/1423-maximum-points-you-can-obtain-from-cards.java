class Solution {
    public int maxScore(int[] cardPoints, int k) {
         int n = cardPoints.length;

            int windowSize = n - k;
    int totalSum = 0;
        for (int x : cardPoints) totalSum += x;


          int windowSum = 0;
    for (int i = 0; i < windowSize; i++) {
        windowSum += cardPoints[i];
        }
        
        int minWindowSum = windowSum;
        for (int i = windowSize; i < n; i++) {
        windowSum += cardPoints[i];
        windowSum -= cardPoints[i - windowSize];
        minWindowSum = Math.min(minWindowSum, windowSum);
    }

    return totalSum - minWindowSum;
    }
}