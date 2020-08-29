package leetcode;

public class num416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 != 0)
            return false;
        int length = sum / 2;
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = length; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[length];
    }
}