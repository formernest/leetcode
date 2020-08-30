package leetcode;

import java.util.Arrays;

class num41 {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int min = 1;
        for (int i = 0; i < len; i++) {
            if (nums[i] == min) {
                min += 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, -1, 1 };
        num41 solution = new num41();
        System.out.println(solution.firstMissingPositive(nums));
    }
}