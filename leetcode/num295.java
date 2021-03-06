package leetcode;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    private Queue<Integer> small;
    private Queue<Integer> large; // 从小到大，存放右半边偏大的数
    int count = 0;

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<Integer>((i1, i2) -> (i2 - i1));
        large = new PriorityQueue<Integer>(); // 从小到大，存放右半边偏大的数
    }

    public void addNum2(int num) {
        if (count % 2 == 0)
            small.offer(num);
        else
            large.offer(num);
        if (!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            small.offer(large.poll());
            large.offer(small.poll());
        }
        count += 1;
    }

    /**
     * 始终维持small.size > large.size
     * @param num
     */
    public void addNum(int num) {
        small.offer(num);
        large.offer(small.poll());
        if (large.size() > small.size()){
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        return small.size() > large.size() ? small.peek() : (small.peek() + large.peek()) / 2.0;
    }
}