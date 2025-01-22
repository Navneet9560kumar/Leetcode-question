class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
         int n=aliceValues.length;
         int m = bobValues.length;

         List<int[]>stones = new ArrayList<>();
          for (int i = 0; i < n; i++) {
            stones.add(new int[]{aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]});
            }
                 Collections.sort(stones, (a, b) -> b[0] - a[0]);
                  int aliceScore = 0, bobScore = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { 
                aliceScore += stones.get(i)[1];
            } else { 
                bobScore += stones.get(i)[2];
            }
        }
        if (aliceScore > bobScore) {
            return 1;
        } else if (bobScore > aliceScore) {
            return -1;
        } else {
            return 0;
        }
    }
}