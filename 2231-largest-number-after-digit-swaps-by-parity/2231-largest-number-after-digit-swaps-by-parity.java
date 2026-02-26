class Solution {
    public int largestInteger(int num) {
          String s = String.valueOf(num);

                  
        PriorityQueue<Integer> evenHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> oddHeap = new PriorityQueue<>(Collections.reverseOrder());

        // fill the heap
        for(char c: s.toCharArray()){
            int digit = c -'0';
            if(digit%2==0){
                evenHeap.add(digit);
            }else{
             oddHeap.add(digit);
            }
        }
         StringBuilder result = new StringBuilder();
          // Step 2: Build largest number
           for (char c : s.toCharArray()){
            int digit =c- '0';
            if (digit % 2 == 0) {
                result.append(evenHeap.poll());
            } else {
                result.append(oddHeap.poll());
            }
        }
        
        return Integer.parseInt(result.toString());
           
    }
}