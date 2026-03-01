class Solution {
    public int leastInterval(char[] tasks, int n) {
        int []freq = new int[26];
         // Step 1: count frequency
        for (char task : tasks) {
            freq[task - 'A']++;
        }
         // Step 2: max heap
        PriorityQueue<Integer> maxHeap =new PriorityQueue<>(Collections.reverseOrder());
        
        for (int f : freq) {
            if (f > 0) {
                maxHeap.add(f);
            }
        }
        
        int time = 0;

        // Step 3: process
        while(!maxHeap.isEmpty()){
        
            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;
             while (cycle > 0 && !maxHeap.isEmpty()) {
                
                int current = maxHeap.poll();
                
                if (current - 1 > 0) {
                    temp.add(current - 1);
                }
                
                time++;
                cycle--;
            }
             // push back remaining tasks
            for (int remaining : temp) {
                maxHeap.add(remaining);
            }
            
            if (maxHeap.isEmpty()) break;
            
            time += cycle; // idle time
        }
        
        return time;

        
    }
}