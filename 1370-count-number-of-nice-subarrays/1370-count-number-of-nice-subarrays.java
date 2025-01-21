class Solution {
   public int numberOfSubarrays(int[] nums, int k) {
        int count = 0; 
        int oddCount = 0;
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); 

        for (int num : nums) {
       
            if (num % 2 != 0) {
                oddCount++;
            }
                if (prefixMap.containsKey(oddCount - k)) {
                count += prefixMap.get(oddCount - k);
            }

          
            prefixMap.put(oddCount, prefixMap.getOrDefault(oddCount, 0) + 1);
        }

        return count;
    }
}