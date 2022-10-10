// we are sepearte num from mid , if both of the size if equal then take median maxheap.top() + minheap.top()  /  2
// if min.pq - max.pq > 1 then whose size is greator remove its vtop and add into  other  

class MedianFinder {
    PriorityQueue<Integer> left, right;
    
    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder()); // Max Heap
        right = new PriorityQueue<>(); // Min Heap
    }
    
    public void addNum(int num) {
        // Insertion
        double median = findMedian();
        if(num <= median){
            left.add(num);
        } else {
            right.add(num);
        }
        if(Math.abs(left.size() - right.size()) > 1){
            if(left.size() > right.size()){
                right.add(left.remove());
            }
            else{
                left.add(right.remove());
            }
        }
    }
    
    // Find Median -> Time = O(1)
    public double findMedian() {
        if(left.size() + right.size() == 0) return -1;
        
        if(left.size() == right.size()){
            return (left.peek() + right.peek()) / 2.0;
        } else if(left.size() == right.size() + 1){
            return left.peek();
        } else {
            return right.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */