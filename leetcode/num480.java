package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

class num480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new double[0];
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if (left.size() <= right.size()) {
                right.add(nums[i]);
                left.add(right.poll());
            } else {
                left.offer(nums[i]);
                right.offer(left.poll());
            }
            if (left.size() + right.size() == k) {
                double mid = 0;
                if (left.size() > right.size()) {
                    mid = left.peek();
                } else {
                    mid = ((long) left.peek() + (long) right.peek()) / 2.0;
                }
                int index = i - k + 1;
                result[index] = mid;
                if (!left.remove(nums[index])) {
                    right.remove(nums[index]);
                }
            }
        }
        return result;
    }
}