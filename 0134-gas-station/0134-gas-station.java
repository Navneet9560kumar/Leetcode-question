class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_tank = 0, current_tank = 0, start_index = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total_tank = total_tank + diff;
            current_tank = current_tank + diff;
            //1-3=-2
            // tot = 0+-2= -2;
            //start= 0+-2 =-2


            if (current_tank < 0) {
                start_index = i + 1;
                current_tank = 0;
            }
        }
        
        if (total_tank >= 0) {
            return start_index;
        } else {
            return -1;
        
    }

    }
}