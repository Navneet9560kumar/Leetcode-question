class Solution {
     public long pickGifts(int[] gifts, int k) {
        // Use a max-heap to efficiently extract the maximum value
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Insert all gifts into the max-heap
        for (int gift : gifts) {
            maxHeap.add(gift);
        }

        // Perform the k operations
        for (int i = 0; i < k; i++) {
            int maxGift = maxHeap.poll(); // Get the maximum value
            int reducedGift = (int) Math.floor(Math.sqrt(maxGift)); // Modify it
            maxHeap.add(reducedGift); // Push the modified value back into the heap
        }

        // Calculate the total sum
        long totalGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalGifts += maxHeap.poll(); // Sum all elements
        }

        return totalGifts;
    }
}