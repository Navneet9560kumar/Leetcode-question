class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[]endTimes = new int[n];
        Arrays.fill(endTimes,-1);

             int targetArrivalTime = times[targetFriend][0];
               Arrays.sort(times, (a, b) -> a[0] - b[0]); // Sorting based on arrival time
               for(int[]time:times){
                int arrival =time[0];
                int depart = time[1];

              // Find the first unoccupied chair
              for(int i=0;i<n;i++){
                if(endTimes[i]<=arrival){
                    endTimes[i] = depart;
                    
                    if (arrival == targetArrivalTime)
                        return i;
                    break;
                }
              }
               }
               return -1;
    }
}