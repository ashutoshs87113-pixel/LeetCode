class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
   minHeap = new PriorityQueue<>();
   maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
     if(maxHeap.size() == 0) {
         maxHeap.add(num);
     }else{
         if(num > maxHeap.peek()) minHeap.add(num);
         else maxHeap.add(num);
     }
     if(maxHeap.size() == minHeap.size() + 2) {
         minHeap.add(maxHeap.remove());
     }
     if(minHeap.size() == maxHeap.size() + 2) {
         maxHeap.add(minHeap.remove());
     }
    }

    public double findMedian() {
      if(maxHeap.size() == minHeap.size() + 1) {
         return maxHeap.peek();
      }
      if(minHeap.size() == maxHeap.size() + 1) {
         return minHeap.peek();
      }
      return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */