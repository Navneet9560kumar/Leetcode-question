class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
      int lastTime = 0;

        for (int pos : left)
            lastTime = Math.max(lastTime, pos);

        for (int pos : right)
            lastTime = Math.max(lastTime, n - pos);

        return lastTime;
        
    }
}