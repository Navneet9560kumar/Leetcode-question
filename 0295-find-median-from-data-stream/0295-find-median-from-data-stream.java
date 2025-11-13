import java.util.*;

class MedianFinder {

    private PriorityQueue<Integer> maxHeap; // lower half
    private PriorityQueue<Integer> minHeap; // upper half

    // ✅ Constructor name must match class name
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek())
            maxHeap.offer(num);
        else
            minHeap.offer(num);

        // balance heaps
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
        else if (minHeap.size() > maxHeap.size())
            maxHeap.offer(minHeap.poll());
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
}

/**
 * Example usage:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(1);
 * obj.addNum(2);
 * System.out.println(obj.findMedian()); // 1.5
 * obj.addNum(3);
 * System.out.println(obj.findMedian()); // 2.0
 */
