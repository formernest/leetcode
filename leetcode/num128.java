package leetcode;

import java.util.HashMap;

// 100, 4, 200, 1, 3, 2
class num128 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                continue;
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            max = Math.max(sum, max);
            map.put(num, sum);
            if (left > 0)
                map.put(num - left, sum);
            if (right > 0)
                map.put(num + right, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        num128 solution = new num128();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        int result = solution.longestConsecutive(nums);
        System.out.println(result);
    }
}