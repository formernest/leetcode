package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums);
        if (nums.length == 0)
            return res;
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] path = new int[nums.length];
        int max = 0;
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        path[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        while (max > 0) {
            res.add(nums[maxIndex]);
            maxIndex = path[maxIndex];
            max--;
        }
        return res;
    }
}