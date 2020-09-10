package leetcode;

import java.util.LinkedList;

class num239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peek() == i - k)
                queue.poll();
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
                queue.removeLast();
            queue.add(i);
            if (i >= k - 1)
                res[i - k + 1] = nums[queue.peek()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        num239 solution = new num239();
        int[] res = solution.maxSlidingWindow(nums, k);
        for (int item : res) {
            System.out.println(item);
        }
    }
}