package leetcode;
class num53 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            if(dp[i-1] + nums[i] > nums[i]) {
                dp[i] = dp[i-1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            max = dp[i] > max? dp[i]:max;
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        num53 solution = new num53();
        System.out.println(solution.maxSubArray(nums));
    }
}