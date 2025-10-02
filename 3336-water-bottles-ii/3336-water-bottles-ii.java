class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;

        while (numBottles >= numExchange) {
            ans += numExchange;        // drink numExchange bottles
            numBottles -= numExchange; // remove drunk bottles
            numBottles++;              // exchange empty bottles for 1 new bottle
            numExchange++;             // next time exchange cost increases
        }

        ans += numBottles; // drink remaining bottles
        return ans;
    }
}
